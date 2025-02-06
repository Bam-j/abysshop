document.addEventListener("DOMContentLoaded", () => {
  const dropdownItems = document.querySelectorAll(".dropdown-item");
  const dropdownButton = document.getElementById("dropdown-button");
  const newStateInput = document.getElementById("newState");

  dropdownItems.forEach(item => {
    item.addEventListener("click", event => {
      event.preventDefault();

      // 클릭한 아이템과 가장 가까운 btn-group 찾기
      const selectedItem = event.target.closest("a");
      const selectedText = selectedItem.textContent;
      const selectedValue = selectedItem.getAttribute("data-value");

      // 클릭된 아이템이 속한 row(행)에서 버튼과 input 찾기
      const btnGroup = selectedItem.closest(".btn-group");
      const dropdownButton = btnGroup.querySelector(".dropdown-toggle");
      const newStateInput = btnGroup.querySelector(".newState");



      // 드롭다운 버튼 텍스트 변경
      dropdownButton.textContent = selectedText;
      // hidden input 값 변경
      newStateInput.value = selectedValue;

      /*
      const selectedItem = event.target.closest("a");
      const selectedText = selectedItem.textContent;
      const selectedValue = selectedItem.getAttribute("data-value");

      dropdownButton.textContent = selectedText;
      newStateInput.value = selectedValue;
      */
    });
  });
});