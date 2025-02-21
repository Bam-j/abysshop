document.addEventListener("DOMContentLoaded", () => {
  const stateMapping = {
    pending_payment: "송금 확인 대기",
    pending_point_deposit: "포인트 지급 대기",
    shipping: "상품 지급 대기",
    completed: "상품 지급 완료",
    refunded: "환불 처리 완료"
  };

  document.querySelectorAll("#dropdown-button").forEach(button => {
    const orderState = button.textContent.trim();
    if (stateMapping[orderState]) {
      button.textContent = stateMapping[orderState];
    }
  });
});