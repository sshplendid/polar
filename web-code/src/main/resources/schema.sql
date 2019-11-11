DROP TABLE IF EXISTS code_group;
CREATE TABLE code_group(
ID number PRIMARY KEY
, group_key VARCHAR(255)
, group_value VARCHAR(255)
, description VARCHAR(255)
, deleted number
, created_at timestamp
, modified_at timestamp
);

DROP TABLE IF EXISTS code;
CREATE TABLE code(
ID INT PRIMARY KEY
, group_key VARCHAR(255)
, code_key VARCHAR(255)
, code_value VARCHAR(255)
, sequence number
, description VARCHAR(255)
, selectable number
, deleted number
, filter_1 VARCHAR(255)
, filter_2 VARCHAR(255)
, filter_3 VARCHAR(255)
, created_at timestamp
, modified_at timestamp
);
