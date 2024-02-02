//문제 설명
//선분 세 개로 삼각형을 만들기 위해서는 다음과 같은 조건을 만족해야 합니다.
// 가장 긴 변의 길이는 다른 두 변의 길이의 합보다 작아야 합니다.
// 삼각형의 두 변의 길이가 담긴 배열 sides이 매개변수로 주어집니다.
// 나머지 한 변이 될 수 있는 정수의 개수를 return하도록 solution 함수를 완성해주세요.

class Stack {
  constructor() {
    this.index = 0;
    this.arr = [];
  }
  
  push(side) {
    this.arr[this.index++] = side;
  }

  size() {
    this.arr.length;
  }
}

function completionConditionOfTriangle(sides) {
  let stack = new Stack();
  sides.sort();

  // sides[1] is Max Length
  for (let i = sides[1] - sides[0] + 1; i <= sides[1]; i++) {
    stack.push(i);
  }

  // There is no Max Length in sides array
  for (let i = sides[1] + 1; i < sides[0] + sides[1]; i++) {
    stack.push(i);
  }

  return stack.size();
}

export default { completionConditionOfTriangle };
