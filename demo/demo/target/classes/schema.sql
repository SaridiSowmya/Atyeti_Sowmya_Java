DROP TABLE IF EXISTS employeeentity;
CREATE TABLE employeeentity (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    department VARCHAR(50),
    salary DOUBLE
);
