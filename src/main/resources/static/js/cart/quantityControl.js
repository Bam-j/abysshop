const quantityControl = operator => {
  const resultElement = document.getElementById('result');

  let number = resultElement.innerText;

  if(operator === 'plus') {
    number = parseInt(number) + 1;
  }else if(operator === 'minus')  {
    number = parseInt(number) - 1;
  }

  resultElement.innerText = number;
};