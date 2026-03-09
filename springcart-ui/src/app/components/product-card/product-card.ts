import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { Product } from '../../models/Product.model';
import { CartService } from '../../services/cart';

@Component({
  selector: 'app-product-card',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './product-card.html',
})
export class ProductCardComponent {
  @Input() product!: Product;
  added = false;

  constructor(public cartService: CartService) {}

  addToCart() {
    this.cartService.add(this.product);
    this.added = true;
    setTimeout(() => this.added = false, 1500);
  }

  get discount(): number {
    if (!this.product.originalPrice) return 0;
    return Math.round((1 - this.product.price / this.product.originalPrice) * 100);
  }
}