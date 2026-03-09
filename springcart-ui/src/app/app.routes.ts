import { Routes } from '@angular/router';
import { LoginComponent } from './components/login/login';
import { RegisterComponent } from './components/register/register';
import { ProductsPageComponent } from './components/products-page/products-page';
import { CartSidebarComponent } from './components/cart-sidebar/cart-sidebar';
import { ProductDetailComponent } from './components/product-details/product-details';
export const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'products', component: ProductsPageComponent },
  { path: 'products/:id', component: ProductDetailComponent },
  { path: 'cart', component: CartSidebarComponent },
  { path: '', redirectTo: 'products', pathMatch: 'full' },
];