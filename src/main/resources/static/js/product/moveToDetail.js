const items = document.getElementsByClassName('item');

Array.from(items).forEach(item => {
  item.addEventListener('click', () => {
    const productId = item.dataset.productId;
    const url = `/product/detail/${productId}`;

    window.location.href = url;
  });
});