document.addEventListener("DOMContentLoaded", () => {
  const addProductForm = document.getElementById("add-product-form");

  addProductForm.addEventListener("submit", event => {
    const productNameInput = document.getElementById("product-name");
    const productPriceInput = document.getElementById("product-price");
    const productDescriptionInput = document.getElementById(
        "product-description");

    //각 입력이 빈 칸인지 검증
    if (!productNameInput.value.trim()) {
      window.alert("상품명을 입력해주세요.");
      event.preventDefault();
    } else if (!productPriceInput.value.trim()) {
      window.alert("가격(요구 포인트)을 입력해주세요.");
      event.preventDefault();
    } else if (!productDescriptionInput.value.trim()) {
      window.alert("상품 설명을 입력해주세요.");
      event.preventDefault();
    }

    //price가 숫자가 아닌 입력이 들어왔는지 검증
    if (isNaN(productPriceInput)) {
      window.alert("숫자만 입력이 가능합니다.");
      event.preventDefault();
    }

    //price가 0원 이하로 입력됐는지 검증
    if (Number(productPriceInput) <= 0) {
      window.alert("0원 이하의 값은 입력할 수 없습니다.");
      event.preventDefault();
    }
  });
});