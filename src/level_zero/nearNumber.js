// 정수 배열 array와 정수 n이 매개변수로 주어질 때,
// array에 들어있는 정수 중 n과 가장 가까운 수를 return 하도록 solution 함수를 완성해주세요.
// 가장 가까운 수가 여러 개일 경우 더 작은 수를 return 합니다.

function nearNumber(array, n) {
  let newArray = new Array();
  let newObject = new Object();
  function getKeyByValue(obj, value) {
    return Object.keys(obj).find((key) => obj[key] === value);
  }

  array.map((x) => {
    newObject[x] = Math.abs(x - n);
    newArray.push(Math.abs(x - n));
  });

  newArray = newArray.sort((a, b) => a - b);
  let theSmallest = Number(getKeyByValue(newObject, newArray[0]));

  newArray.map((x) => {
    if (newArray[0] === x && theSmallest > Number(getKeyByValue(newObject, x)))
      theSmallest = newObject[x];
  });

  return theSmallest;
}

export default { nearNumber };