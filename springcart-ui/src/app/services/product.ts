import { Injectable } from '@angular/core';
import { Product } from '../models/Product.model';

@Injectable({ providedIn: 'root' })
export class ProductService {
  private products: Product[] = [
    {
      id: 1,
      name: 'iPhone 15 Pro',
      brand: 'Apple',
      category: 'Phones',
      price: 999,
      originalPrice: 1099,
      image: 'https://images.unsplash.com/photo-1695048133142-1a20484d2569?w=400',
      rating: 4.8,
      reviews: 2341,
      badge: 'Best Seller',
      description: 'The most powerful iPhone ever with A17 Pro chip and titanium design.',
      specs: { Display: '6.1" Super Retina XDR', Chip: 'A17 Pro', Storage: '256GB', Camera: '48MP Main' }
    },
    {
      id: 2,
      name: 'Samsung Galaxy S24 Ultra',
      brand: 'Samsung',
      category: 'Phones',
      price: 1199,
      originalPrice: 1299,
      image: 'https://images.unsplash.com/photo-1610945415295-d9bbf067e59c?w=400',
      rating: 4.7,
      reviews: 1876,
      badge: 'New',
      description: 'Ultimate Android experience with S Pen and 200MP camera.',
      specs: { Display: '6.8" Dynamic AMOLED', Chip: 'Snapdragon 8 Gen 3', Storage: '256GB', Camera: '200MP Main' }
    },
    {
      id: 3,
      name: 'Sony WH-1000XM5',
      brand: 'Sony',
      category: 'Headphones',
      price: 349,
      originalPrice: 399,
      image: 'https://images.unsplash.com/photo-1618366712010-f4ae9c647dcb?w=400',
      rating: 4.9,
      reviews: 5432,
      badge: 'Top Rated',
      description: 'Industry-leading noise cancellation with 30-hour battery life.',
      specs: { 'Battery Life': '30 hours', 'Noise Cancellation': 'Yes', Connectivity: 'Bluetooth 5.2', Weight: '250g' }
    },
    {
      id: 4,
      name: 'AirPods Pro 2',
      brand: 'Apple',
      category: 'Headphones',
      price: 249,
      image: 'https://images.unsplash.com/photo-1600294037681-c80b4cb5b434?w=400',
      rating: 4.7,
      reviews: 3210,
      description: 'Next-level Active Noise Cancellation with Adaptive Audio.',
      specs: { 'Battery Life': '6 hours', 'Noise Cancellation': 'Adaptive', Chip: 'H2', 'Water Resistance': 'IPX4' }
    },
    {
      id: 5,
      name: 'iPad Pro 12.9"',
      brand: 'Apple',
      category: 'Tablets',
      price: 1099,
      originalPrice: 1199,
      image: 'https://images.unsplash.com/photo-1544244015-0df4b3ffc6b0?w=400',
      rating: 4.8,
      reviews: 987,
      badge: 'Sale',
      description: 'Supercharged by M2 chip with the most advanced display ever in an iPad.',
      specs: { Display: '12.9" Liquid Retina XDR', Chip: 'M2', Storage: '256GB', Connectivity: 'Wi-Fi 6E' }
    },
    {
      id: 6,
      name: 'Samsung Galaxy Tab S9',
      brand: 'Samsung',
      category: 'Tablets',
      price: 799,
      image: 'https://images.unsplash.com/photo-1561154464-82e9adf32764?w=400',
      rating: 4.6,
      reviews: 654,
      description: 'Premium Android tablet with Dynamic AMOLED display and S Pen.',
      specs: { Display: '11" Dynamic AMOLED', Chip: 'Snapdragon 8 Gen 2', Storage: '128GB', Battery: '8400mAh' }
    },
    {
      id: 7,
      name: 'MacBook Pro 14"',
      brand: 'Apple',
      category: 'Laptops',
      price: 1999,
      originalPrice: 2199,
      image: 'https://images.unsplash.com/photo-1517336714731-489689fd1ca8?w=400',
      rating: 4.9,
      reviews: 1543,
      badge: 'Premium',
      description: 'Supercharged by M3 Pro chip for professionals.',
      specs: { Display: '14.2" Liquid Retina XDR', Chip: 'M3 Pro', RAM: '18GB', Storage: '512GB SSD' }
    },
    {
      id: 8,
      name: 'Apple Watch Ultra 2',
      brand: 'Apple',
      category: 'Wearables',
      price: 799,
      image: 'https://images.unsplash.com/photo-1546868871-7041f2a55e12?w=400',
      rating: 4.7,
      reviews: 876,
      badge: 'New',
      description: 'The most rugged and capable Apple Watch ever made.',
      specs: { Display: '49mm Always-On', Battery: '60 hours', 'Water Resistance': '100m', Chip: 'S9 SiP' }
    },
  ];

  getAll(): Product[] {
    return this.products;
  }

  getById(id: number): Product | undefined {
    return this.products.find(p => p.id === id);
  }

  getCategories(): string[] {
    return ['All', ...new Set(this.products.map(p => p.category))];
  }

  getByCategory(category: string): Product[] {
    return category === 'All' ? this.products : this.products.filter(p => p.category === category);
  }

  search(query: string): Product[] {
    const q = query.toLowerCase();
    return this.products.filter(p =>
      p.name.toLowerCase().includes(q) ||
      p.brand.toLowerCase().includes(q) ||
      p.category.toLowerCase().includes(q)
    );
  }
}