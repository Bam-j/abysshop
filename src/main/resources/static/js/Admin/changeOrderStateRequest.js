const dropdownItems = document.querySelectorAll('.dropdown-item');
const newStateValue = document.getElementById('newState');
const form = document.querySelector('form');

dropdownItems.forEach(item => {
  item.addEventListener('click', () => {
    const selectedValue = item.dataset.value;

    newStateValue.value = selectedValue;
    form.submit();
  });
});