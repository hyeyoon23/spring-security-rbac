-- 1. 데이터베이스 생성 및 사용
CREATE DATABASE IF NOT EXISTS spring_security_auth;
USE spring_security_auth;

-- 2. 기존 테이블 삭제 (자식 테이블인 Authority를 먼저 삭제)
DROP TABLE IF EXISTS Authority;
DROP TABLE IF EXISTS User;

-- 3. User 테이블 생성
CREATE TABLE User (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(50) NOT NULL,       -- 이름
  position VARCHAR(50)             -- 직책
);

-- 4. Authority 테이블 생성
CREATE TABLE Authority (
   id BIGINT AUTO_INCREMENT PRIMARY KEY,
   authority VARCHAR(50) NOT NULL,  -- 권한 (예: ROLE_USER, ROLE_ADMIN)
   user_id BIGINT NOT NULL,         -- User 테이블 참조속성 (FK)
   FOREIGN KEY (user_id) REFERENCES User(id) ON DELETE CASCADE
);