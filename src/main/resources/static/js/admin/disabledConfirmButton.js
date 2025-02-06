document.addEventListener("DOMContentLoaded", () => {
  const confirmButton = document.getElementById("provide-confirm-button");

  confirmButton.addEventListener("submit", event => {
    //클릭 후 disabled는 되나, redirect 동작 후에 disabled가 해제됨
    confirmButton.disabled = true;
    confirmButton.textContent = "지급 완료";
  });
});