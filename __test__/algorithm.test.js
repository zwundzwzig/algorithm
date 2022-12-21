import {
  fountain,
  mode,
  isCompositeNumber,
  nearNumber,
  binaryNumber,
  throwBall,
  sharingMarble,
  alienLanguageDic,
  locationOfCharacter,
  completionConditionOfTriangle,
} from "../src/level_zero";

describe("fountain", () => {
  test("case1", () => {
    expect(fountain(1, 2, 3, 4)).toEqual([5, 4]);
  });

  test("case2", () => {
    expect(fountain(9, 2, 1, 3)).toEqual([29, 6]);
  });

  test("case3", () => {
    expect(fountain(12, 44, 44, 22)).toEqual([25, 11]);
  });
});

describe("mode", () => {
  test("case1", () => {
    expect(mode([1, 1, 2, 2])).toEqual(-1);
  });

  test("case2", () => {
    expect(mode([1])).toEqual(1);
  });

  test("case3", () => {
    expect(mode([1, 1, 1, 2, 2, 3])).toEqual(1);
  });
});

describe("isCompositeNumber", () => {
  test("case1", () => {
    expect(isCompositeNumber(10)).toEqual(5);
  });

  test("case2", () => {
    expect(isCompositeNumber(15)).toEqual(8);
  });

  test("case3", () => {
    expect(isCompositeNumber(17)).toEqual(9);
  });
});

describe("nearNumber", () => {
  test("case1", () => {
    expect(nearNumber([3, 10, 28], 20)).toEqual(28);
  });

  test("case2", () => {
    expect(nearNumber([10, 11, 12], 13)).toEqual(12);
  });

  test("case3", () => {
    expect(nearNumber([123, 334, 33, 1, 25], 13)).toEqual(1);
  });
});

describe("binaryNumber", () => {
  test("case1", () => {
    expect(binaryNumber("10", "11")).toEqual("101");
  });

  test("case2", () => {
    expect(binaryNumber("1001", "1111")).toEqual("11000");
  });

  test("case3", () => {
    expect(binaryNumber("1", "1")).toEqual("10");
  });
});

describe("throwBall", () => {
  test("case1", () => {
    expect(throwBall([1, 2, 3, 4], 2)).toEqual(3);
  });

  test("case2", () => {
    expect(throwBall([1, 2, 3, 4, 5, 6], 5)).toEqual(3);
  });

  test("case3", () => {
    expect(throwBall([1, 2, 3], 3)).toEqual(2);
  });
});

describe("sharingMarble", () => {
  test("case1", () => {
    expect(sharingMarble(3, 2)).toEqual(3);
  });

  test("case2", () => {
    expect(sharingMarble(5, 3)).toEqual(10);
  });

  test("case3", () => {
    expect(sharingMarble(5, 4)).toEqual(5);
  });
});

describe("alienLanguageDic", () => {
  test("case1", () => {
    expect(
      alienLanguageDic(["p", "o", "s"], ["sod", "eocd", "qixm", "adio", "soo"])
    ).toEqual(2);
  });
  test("case2", () => {
    expect(
      alienLanguageDic(["z", "d", "x"], ["def", "dww", "dzx", "loveaw"])
    ).toEqual(1);
  });
  test("case3", () => {
    expect(
      alienLanguageDic(
        ["s", "o", "m", "d"],
        ["moos", "dzx", "smm", "sunmmo", "som"]
      )
    ).toEqual(2);
  });
});

describe("deleteZandChar", () => {
  test("case1", () => {
    expect(deleteZandChar("1 2 Z 3")).toEqual(4);
  });

  test("case2", () => {
    expect(deleteZandChar("10 20 30 40")).toEqual(100);
  });

  test("case3", () => {
    expect(deleteZandChar("-1 -2 -3 Z")).toEqual(-3);
  });
});

describe("locationOfCharacter", () => {
  test("case1", () => {
    expect(
      locationOfCharacter(["left", "right", "up", "right", "right"], [11, 11])
    ).toEqual([2, 1]);
  });

  test("case2", () => {
    expect(
      locationOfCharacter(["down", "down", "down", "down", "down"], [7, 9])
    ).toEqual([0, -4]);
  });

  test("case3", () => {
    expect(locationOfCharacter(["up"], [0, 0])).toEqual([1, 0]);
  });
});

describe("completionConditionOfTriangle", () => {
  test("case1", () => {
    expect(completionConditionOfTriangle([1, 2])).toEqual(1);
  });

  test("case2", () => {
    expect(completionConditionOfTriangle([3, 6])).toEqual(5);
  });

  test("case3", () => {
    expect(completionConditionOfTriangle([11, 7])).toEqual(13);
  });
});

describe("logInComplete", () => {
  test("case1", () => {
    expect(
      logInComplete(
        ["meosseugi", "1234"],
        [
          ["rardss", "123"],
          ["yyoom", "1234"],
          ["meosseugi", "1234"],
        ]
      )
    ).toEqual("login");
  });

  test("case2", () => {
    expect(
      logInComplete(
        ["programmer01", "15789"],
        [
          ["programmer02", "111111"],
          ["programmer00", "134"],
          ["programmer01", "1145"],
        ]
      )
    ).toEqual("wrong pw");
  });

  test("case3", () => {
    expect(
      logInComplete(
        ["rabbit04", "98761"],
        [
          ["jaja11", "98761"],
          ["krong0313", "29440"],
          ["rabbit00", "111333"],
        ]
      )
    ).toEqual("fail");
  });
});
