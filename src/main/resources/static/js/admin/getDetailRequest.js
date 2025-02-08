const getDetailRequest = rechargeId => {
  const url = `/point/recharge/detail?rechargeId=${rechargeId}`
  console.log(url);

  fetch(url, {method: "GET"})
  .then(response => {
    if (!response.ok) {
      throw new Error(`HTTP error! Status: ${response.status}`);
    }
  })
  .catch(error => {
    console.error(error);
  });
}
