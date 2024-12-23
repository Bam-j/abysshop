const item = document.getElementsByClassName('item');

item.forEach(card => {
  card.addEventListener('click', () => {
    //TODO: id 방식 결정하고 id 취득하는 코드 작성
    const id = '';
    const url = `/product/detail/${id}`;

    fetch(url)
    .then(response => response.json())
    .then(data => {
      console.log(data);
    })
    .catch(error => {
      console.error('Error:', error);
    });
  });
});