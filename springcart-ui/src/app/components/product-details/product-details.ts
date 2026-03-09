import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { NavbarComponent } from '../navbar/navbar';
import { ProductCardComponent } from '../product-card/product-card';
import { ProductService } from '../../services/product';
import { CartService } from '../../services/cart';
import { Product } from '../../models/Product.model';

@Component({
  selector: 'app-product-detail',
  standalone: true,
  imports: [CommonModule, RouterLink, NavbarComponent, ProductCardComponent],
  templateUrl: './product-details.html',
})
export class ProductDetailComponent implements OnInit {
  product?: Product;
  related: Product[] = [];
  added = false;
  quantity = 1;

  constructor(
    private route: ActivatedRoute,
    private productService: ProductService,
    public cartService: CartService
  ) {}

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.product = this.productService.getById(+params['id']);
      if (this.product) {
        this.related = this.productService
          .getByCategory(this.product.category)
          .filter(p => p.id !== this.product!.id)
          .slice(0, 4);
      }
    });
  }

  addToCart() {
    if (!this.product) return;
    for (let i = 0; i < this.quantity; i++) this.cartService.add(this.product);
    this.added = true;
    setTimeout(() => this.added = false, 1500);
  }

  get discount(): number {
    if (!this.product?.originalPrice) return 0;
    return Math.round((1 - this.product.price / this.product.originalPrice) * 100);
  }

  specKeys(): string[] {
    return this.product ? Object.keys(this.product.specs) : [];
  }
}