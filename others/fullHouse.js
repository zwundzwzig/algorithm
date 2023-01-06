// 특정한 순서대로 주어지는 트럼프 카드들을 모아 최대한 많은 수의 풀하우스를 만들려고 합니다.
// 풀하우스는 포커 족보 중 하나로, 같은 숫자 3장과 또 다른 숫자 2장으로 이뤄진 카드 조합입니다.
// 예를 들어 [1, 2, 2, 1, 1]은 1이 3장, 2가 2장이라 풀하우스 조건을 성립합니다.

// 카드를 한 장씩 주어진 순서대로 받을 때 들고 있는 카드 중 5장을 이용해 풀하우스를 만들면 1점을 얻고 모든 카드를 버립니다.
// 설령 2개 이상의 풀하우스를 만들 수 있어도 1점만 획득하고 모든 카드를 버려야 합니다.
// 조커는 모든 숫자로 변환될 수 있고, 이 문제에선 0으로 주어질 때,
// 주어진 카드의 숫자를 순서대로 담는 1차원 정수 배열 cards가 매개변수로 주어지고,
// 풇하우스를 완성해 최대 몇 점을 받을 수 있는지 return하도록 solution 함수를 완성시키세요.

function fullHouse(cards) {
  if (cards.length < 5) return 0;

  let countFullHouse = new Map();

  for (let card of cards) {
    if (!countFullHouse.has(card)) countFullHouse.set(card, 0);
    if (countFullHouse.has(card))
      countFullHouse.set(card, countFullHouse.get(card) + 1);
    if (countFullHouse.get(card) === 0) return 5;
  }

  for (let [k, v] of countFullHouse) {
    for (let [i, j] of countFullHouse) {
      for (let [a, b] of countFullHouse) {
        if (v === 3) return j === 2 ? 1 : j === 1 && a === 0 && b > 1 ? 1 : 0;
        else return 0;
      }
    }
  }
}

export default { fullHouse };
