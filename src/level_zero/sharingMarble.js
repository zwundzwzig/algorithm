// 머쓱이는 구슬을 친구들에게 나누어주려고 합니다.
// 구슬은 모두 다르게 생겼습니다.
// 머쓱이가 갖고 있는 구슬의 개수 balls와 친구들에게 나누어 줄 구슬 개수 share이 매개변수로 주어질 때,
// balls개의 구슬 중 share개의 구슬을 고르는 가능한 모든 경우의 수를 return 하는 solution 함수를 완성해주세요.
// Hint! 서로 다른 n개 중 m개를 뽑는 경우의 수 공식은 다음과 같습니다.
// n! / ((n-m)! * m!)

function factorial(num) {
  var result = BigInt(1);
  if (num === 0 || num === 1) return BigInt(1);
  while (num > 1) {
    result *= BigInt(num--);
  }

  return result;
}

function sharingMarble(balls, share) {
  factorial(balls) / factorial(balls - share) / factorial(share);
}

export default { sharingMarble };
