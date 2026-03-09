import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { NavbarComponent } from '../navbar/navbar';
import { ProductCardComponent } from '../product-card/product-card';
import { ProductService } from '../../services/product';
import { Product } from '../../models/Product.model';

@Component({
  selector: 'app-products-page',
  standalone: true,
  imports: [CommonModule, FormsModule, NavbarComponent, ProductCardComponent],
  templateUrl: './products-page.html',
})
export class ProductsPageComponent implements OnInit {
  products: Product[] = [];
  categories: string[] = [];
  selectedCategory = 'All';
  searchQuery = '';
  sortBy = 'default';

  constructor(private productService: ProductService, private route: ActivatedRoute) {}

  ngOnInit() {
    this.categories = this.productService.getCategories();
    this.route.queryParams.subscribe(params => {
      this.searchQuery = params['search'] || '';
      this.applyFilters();
    });
  }

  applyFilters() {
    let result = this.searchQuery
      ? this.productService.search(this.searchQuery)
      : this.productService.getByCategory(this.selectedCategory);

    if (this.sortBy === 'price-asc') result = [...result].sort((a, b) => a.price - b.price);
    if (this.sortBy === 'price-desc') result = [...result].sort((a, b) => b.price - a.price);
    if (this.sortBy === 'rating') result = [...result].sort((a, b) => b.rating - a.rating);

    this.products = result;
  }

  selectCategory(category: string) {
    this.selectedCategory = category;
    this.searchQuery = '';
    this.applyFilters();
  }
}