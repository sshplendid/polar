DROP TABLE IF EXISTS code_group;
CREATE TABLE code_group(
ID INT PRIMARY KEY
, group_key VARCHAR(255)
, group_value VARCHAR(255)
, description VARCHAR(255)
, deleted number
, created_at timestamp
, modified_at timestamp
);
INSERT INTO code_group VALUES(1, 'GENDER', '성별', '성별 그룹코드', 1, now(), now());
-- SELECT * FROM code_group ORDER BY ID;

DROP TABLE IF EXISTS code;
CREATE TABLE code(
ID INT PRIMARY KEY
, group_key VARCHAR(255)
, code_key VARCHAR(255)
, code_value VARCHAR(255)
, description VARCHAR(255)
, selectable number
, deleted number
, filter_1 VARCHAR(255)
, filter_2 VARCHAR(255)
, filter_3 VARCHAR(255)
, created_at timestamp
, modified_at timestamp
);
INSERT INTO code VALUES(1, 'GENDER', 'MALE', '남성', '성별: 남성', 1, 0, null, null, null, now(), now());
INSERT INTO code VALUES(2, 'GENDER', 'FEMALE', '남성', '성별: 여성', 1, 0, null, null, null, now(), now());
INSERT INTO code VALUES(3, 'GENDER', 'UNKNOWN', '밝히지않음', '성별: 밝히지않음', 1, 0, null, null, null, now(), now());
-- SELECT * FROM code ORDER BY ID;