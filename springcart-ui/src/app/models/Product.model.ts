export interface Product {
  id: number;
  name: string;
  brand: string;
  category: string;
  price: number;
  originalPrice?: number;
  image: string;
  rating: number;
  reviews: number;
  badge?: string;
  description: string;
  specs: { [key: string]: string };
}

export interface CartItem {
  product: Product;
  quantity: number;
}