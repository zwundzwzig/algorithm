//문제 설명
//첫 번째 분수의 분자와 분모를 뜻하는 denum1, num1, 두 번째 분수의 분자와 분모를 뜻하는 denum2, num2가 매개변수로 주어집니다.
//두 분수를 더한 값을 기약 분수로 나타냈을 때 분자와 분모를 순서대로 담은 배열을 return 하도록 solution 함수를 완성해보세요.

function fountain(denum1, num1, denum2, num2) {
  let lcm = 1;

  while (true) {
    if (lcm % num1 === 0 && lcm % num2 === 0) {
      break;
    }
    lcm++;
  }

  const first = lcm / num1;
  const second = lcm / num2;
  const numerator = first * denum1 + second * denum2;

  const getGCD = (a, b) => (a % b === 0 ? b : getGCD(b, a % b));
  const gcd = getGCD(numerator, lcm);

  return [numerator / gcd, lcm / gcd];
}

export default { fountain };
