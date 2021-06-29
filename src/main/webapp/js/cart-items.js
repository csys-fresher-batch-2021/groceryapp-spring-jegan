function addItemToCart(cartItem) {
  let cartItemStr = localStorage.getItem("CART_ITEMS");
  let cartItems = cartItemStr == null ? []: JSON.parse(cartItemStr);
  cartItems.push(cartItem);
  localStorage.setItem("CART_ITEMS", JSON.stringify(cartItems));
}

addItemToCart(cartItem);