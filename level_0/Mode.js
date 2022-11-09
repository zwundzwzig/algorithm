// 최빈값은 주어진 값 중에서 가장 자주 나오는 값을 의미합니다.
// 정수 배열 array가 매개변수로 주어질 때, 최빈값을 return 하도록 solution 함수를 완성해보세요.
// 최빈값이 여러 개면 -1을 return 합니다.

function mode(array) {
  let counting = new Map();
  let countArray = new Array();
  let max = 0;
  for (let i of array) {
    if (!counting.has(i)) counting.set(i, 0);
    if (counting.has(i)) counting.set(i, counting.get(i) + 1);
    while (counting.get(i) > max) max++;
  }

  for (let [k, v] of counting) {
    if (v === max) countArray.push(k, v);
  }

  return countArray.length === 2 ? countArray[0] : -1;
}

export default { mode };