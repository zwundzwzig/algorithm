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
  pushTheString,
  chickenCoupon,
  finiteDecimal,
  rankMathEnglish,
  weirdSorting,
  without3,
  polynomial,
  OXquiz,
  checkResultOfReport,
  nextNumber,
  arithmeticProgression,
  safeZone,
} from "../programmers/level_0";
import { fullHouse } from "../others";

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

describe("dimensionsOfRectangle", () => {
  test("case1", () => {
    expect(
      dimensionsOfRectangle([
        [1, 1],
        [2, 1],
        [2, 2],
        [1, 2],
      ])
    ).toEqual(1);
  });

  test("case2", () => {
    expect(
      dimensionsOfRectangle([
        [-1, -1],
        [1, 1],
        [1, -1],
        [-1, 1],
      ])
    ).toEqual(4);
  });

  test("case3", () => {
    expect(
      dimensionsOfRectangle([
        [0, 0],
        [0, 4],
        [1, 4],
        [1, 0],
      ])
    ).toEqual(4);
  });
});

describe("pushTheString", () => {
  test("case1", () => {
    expect(pushTheString("hello", "ohell")).toEqual(1);
  });

  test("case2", () => {
    expect(pushTheString("apple", "elppa")).toEqual(-1);
  });

  test("case3", () => {
    expect(pushTheString("JavaScript", "JavaScript")).toEqual(0);
  });
});

describe("chickenCoupon", () => {
  test("case1", () => {
    expect(chickenCoupon(100)).toEqual(11);
  });

  test("case2", () => {
    expect(chickenCoupon(1081)).toEqual(120);
  });

  test("case3", () => {
    expect(chickenCoupon(9)).toEqual(9);
  });
});

describe("finiteDecimal", () => {
  test("case1", () => {
    expect(finiteDecimal(7, 20)).toEqual(1);
  });

  test("case2", () => {
    expect(finiteDecimal(11, 22)).toEqual(1);
  });

  test("case3", () => {
    expect(finiteDecimal(12, 21)).toEqual(2);
  });
});

describe("rankMathEnglish", () => {
  test("case1", () => {
    expect(
      rankMathEnglish([
        [80, 70],
        [90, 50],
        [40, 70],
        [50, 80],
      ])
    ).toEqual([1, 2, 4, 3]);
  });

  test("case2", () => {
    expect(
      rankMathEnglish([
        [80, 70],
        [70, 80],
        [30, 50],
        [90, 100],
        [100, 90],
        [100, 100],
        [10, 30],
      ])
    ).toEqual([4, 4, 6, 2, 2, 1, 7]);
  });

  test("case3", () => {
    expect(
      rankMathEnglish([
        [100, 100],
        [0, 0],
      ])
    ).toEqual([1, 2]);
  });
});

describe("weirdSorting", () => {
  test("case1", () => {
    expect(weirdSorting([[1, 2, 3, 4, 5, 6], 4])).toEqual([4, 5, 3, 6, 2, 1]);
  });

  test("case2", () => {
    expect(weirdSorting([[10000, 20, 36, 47, 40, 6, 10, 7000], 30])).toEqual([
      36, 40, 20, 47, 10, 6, 7000, 10000,
    ]);
  });

  test("case3", () => {
    expect(weirdSorting([[101, 1], 51])).toEqual([101, 1]);
  });
});

describe("without3", () => {
  test("case1", () => {
    expect(without3(15)).toEqual(25);
  });

  test("case2", () => {
    expect(without3(40)).toEqual(76);
  });

  test("case3", () => {
    expect(without3(10)).toEqual(16);
  });
});

describe("polynomial", () => {
  test("case1", () => {
    expect(polynomial("2 + 005 + x")).toEqual("4x + 7");
  });

  test("case2", () => {
    expect(polynomial("2 + 9")).toEqual("7");
  });

  test("case3", () => {
    expect(polynomial("010 + 0020x + 1")).toEqual("20x + 11");
  });
});

describe("OXquiz", () => {
  test("case1", () => {
    expect(OXquiz(["3 - 4 = -3", "5 + 6 = 11"])).toEqual(["X", "O"]);
  });

  test("case2", () => {
    expect(
      OXquiz(["19 - 6 = 13", "5 + 66 = 71", "5 - 15 = 63", "3 - 1 = 2"])
    ).toEqual(["O", "O", "X", "O"]);
  });

  test("case3", () => {
    expect(OXquiz(["1 + 1 = 2", "2 - 4 = 2"])).toEqual(["O", "X"]);
  });
});

describe("checkResultOfReport", () => {
  test("case1", () => {
    expect(
      checkResultOfReport(
        ["muzi", "frodo", "apeach", "neo"],
        ["muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"],
        2
      )
    ).toEqual([2, 1, 1, 0]);
  });

  test("case2", () => {
    expect(
      checkResultOfReport(
        ["con", "ryan"],
        ["ryan con", "ryan con", "ryan con", "ryan con"],
        3
      )
    ).toEqual([0, 0]);
  });

  test("case3", () => {
    expect(
      checkResultOfReport(["ho", "rang"], ["ho rang", "rang, ho"], 1)
    ).toEqual([1, 1]);
  });
});

describe("nextNumber", () => {
  test("case1", () => {
    expect(nextNumber([1, 2, 3, 4])).toEqual(5);
  });

  test("case2", () => {
    expect(nextNumber([2, 4, 8])).toEqual(16);
  });

  test("case3", () => {
    expect(nextNumber([1, 10, 100])).toEqual(1000);
  });
});

describe("arithmeticProgression", () => {
  test("case1", () => {
    expect(arithmeticProgression(5, 15)).toEqual([1, 2, 3, 4, 5]);
  });

  test("case2", () => {
    expect(arithmeticProgression(4, 14)).toEqual([2, 3, 4, 5]);
  });

  test("case3", () => {
    expect(arithmeticProgression(5, 5)).toEqual([-1, 0, 1, 2, 3]);
  });
});

describe("safeZone", () => {
  test("case1", () => {
    expect(
      safeZone([
        [0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0],
        [0, 0, 1, 0, 0],
        [0, 0, 0, 0, 0],
      ])
    ).toEqual(16);
  });

  test("case2", () => {
    expect(
      safeZone([
        [0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0],
        [0, 0, 1, 1, 0],
        [0, 0, 0, 0, 0],
      ])
    ).toEqual(13);
  });

  test("case3", () => {
    expect(
      safeZone([
        [1, 1, 1, 1, 1, 1],
        [1, 1, 1, 1, 1, 1],
        [1, 1, 1, 1, 1, 1],
        [1, 1, 1, 1, 1, 1],
        [1, 1, 1, 1, 1, 1],
        [1, 1, 1, 1, 1, 1],
      ])
    ).toEqual(0);
  });
});
