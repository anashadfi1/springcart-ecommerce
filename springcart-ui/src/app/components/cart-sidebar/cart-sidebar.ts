import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { NavbarComponent } from '../navbar/navbar';
import { CartService } from '../../services/cart';

@Component({
  selector: 'app-cart-sidebar',
  standalone: true,
  imports: [CommonModule, RouterLink, NavbarComponent],
  templateUrl: './cart-sidebar.html',
})
export class CartSidebarComponent {
  constructor(public cartService: CartService) {}
}