const item = document.getElementsByClassName('item');

item.forEach(card => {
  card.addEventListener('click', () => {
    //TODO: id 방식 결정하고 id 취득하는 코드 작성
    const itemId = item.dataset.itemId;
    const url = `/product/detail/${itemId}`;

    fetch(url)
    .then(response => {
      if (!response.ok) {
        throw new Error('Network response was not ok');

        return response.json();
      }
    })
    .then(data => {
      console.log(data);
    })
    .catch(error => {
      console.error('Error:', error);
    });
  });
});