-- code group
INSERT INTO code_group VALUES(1, 'COMMON', 'GENDER', '성별', '성별 그룹코드', 0, now(), now());
INSERT INTO code_group VALUES(2, 'COMMON', 'STATUS', '상태', '테스트', 0, now(), now());

-- code
INSERT INTO code VALUES(1, 'GENDER', 'MALE', '남성', 1, '성별: 남성', 1, 0, null, null, null, now(), now());
INSERT INTO code VALUES(2, 'GENDER', 'FEMALE', '남성', 2, '성별: 여성', 1, 0, null, null, null, now(), now());
INSERT INTO code VALUES(3, 'GENDER', 'UNKNOWN', '밝히지않음', 3, '성별: 밝히지않음', 1, 0, null, null, null, now(), now());
INSERT INTO code VALUES(4, 'STATUS', 'BUSY', '바쁨', 1, '바빠', 1, 0, null, null, null, now(), now());
INSERT INTO code VALUES(5, 'STATUS', 'IDLE', '여유있음', 2, '안바빠', 1, 0, null, null, null, now(), now());

