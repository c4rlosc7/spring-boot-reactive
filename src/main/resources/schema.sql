--CREATE TABLE IF NOT EXISTS students (
--    ID INT AUTO_INCREMENT PRIMARY KEY,
    --ID SERIAL PRIMARY KEY,
--    NAME VARCHAR(255) NOT NULL,
--    LAST_NAME VARCHAR(255) NOT NULL,
--    STATE VARCHAR(100) NOT NULL
--);
CREATE TABLE IF NOT EXISTS customer (id SERIAL PRIMARY KEY, first_name VARCHAR(255), last_name VARCHAR(255));