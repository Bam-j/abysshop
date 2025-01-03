# Abysshop
- 어비스 블록 후원 상점 웹 페이지

---
## 프로젝트 개요
- 포인트를 결제수단으로 사용하는 쇼핑몰 웹 페이지
- 디자인 & 동작 매커니즘은 네이버 쇼핑 페이지를 벤치마킹
- 회원제를 통한 회원과 포인트 관리
- 관리자가 포인트 지급, 결제 확인, 상품 전달, 상품 등록의 역할을 수행
- 결제 방식은 실시간 계좌 이체 -> 이체 확인 후 포인트 지급 -> 품목 구매 (1,000원 -> 100포인트) 

## 사용기술 
- 프론트: `HTML5, CSS3, JSP, BootStrap`
- 서버: `Java, Spring & SpringBoot, MyBatis, MySQL, Apache Tomcat`
- 버전 관리: `Git & GitHub`
- 배포: 로컬(개인 노트북)에서 아파치 톰캣을 실행시켜서 배포

## 개발 순서
1. 프론트 엔드 구성
2. 쇼핑몰 시스템 구현
3. 회원 & 관리자 시스템 구현
4. 최종 디자인 입히기

---
# DB
## 테이블
- 상품, 회원, 주문, 장바구니
- 테이블 생성, 테스트를 위한 더미 데이터 삽입은 [sql 디렉토리]()의 `abysshop.sql 및 insertXxxxxDummyData.sql` 파일을 참조해주세요.

## ERD
![abysshop-ERD](https://github.com/user-attachments/assets/e65e04af-9e6c-486c-84ac-b2a66323cd16)

---
# 사용법
## 관리자
- 관리자 계정으로 로그인.
- 관리자 계정은 미리 직접 생성해둔다. (실사용 계정 2개, 테스트용 관리자 계정 1개)
- 테스트용 관리자 계정의 로그인 계정, 닉네임, 비밀번호는 'admin'으로 통일한다.

### 상품 관리
- 상품 관리 페이지에서 상품을 등록하거나 삭제할 수 있다.
- 상품 이미지, 상품명, 상품 설명, 가격을 입력할 수 있는 폼을 통해 입력하고 등록 요청을 보낸다.
- 삭제는 전체 상품 리스트를 조회하고 삭제 버튼을 눌러 요청을 보내고 상품을 삭제한다.

### 포인트 관리
- 포인트 지급 요청을 확인한다.
- 포인트 지급 상태를 사용하여 사용자에게 현재 상태를 알린다.
  - 결제 확인: 포인트 지급 요청 후 관리자가 계좌 이체 여부를 확인하는 단계
  - 포인트 지급 완료: 계좌 이체 확인 후 포인트를 지급한 이후의 단계. 포인트 지급 cycle의 종료 시점.

### 주문 관리
- 주문 관리 페이지에서 들어온 주문을 확인한다.
- 계좌 이체 여부 확인 후 상품을 보내도록 요청한다.
- 주문 상태를 사용하여 사용자에게 현재 상태를 알린다.
  - 결제 확인: 상품 구매 요청 후 관리자가 계좌 이체 여부를 확인하는 단계
  - 상품 발송 대기: 계좌 이체 여부 확인 후 상품을 보내주기 전 단계
  - 상품 발송 완료: 상품을 보내준 이후의 단계. 주문 cycle의 종료 시점.

---
## 회원
### 회원제
- 회원가입 및 로그인을 해야 상품 주문이 가능하다.

### 포인트
- 정책으로 인해 포인트 상품 구매 요청 -> 계좌 이체 -> 정률 포인트 지급제도를 채택한다.
- 포인트는 1000원 당 100포인트로 환산한다. (!!!내부 정책에 따라 변경될 수 있음)
- 회원은 포인트를 통해서만 실제 상품을 구매할 수 있다.
- 포인트 지급 요청을 확인하고 관리자가 관리자 페이지에서 포인트를 지급한다.

### 상품 주문
- 구매하고자하는 상품을 장바구니에 담는다.
- 장바구니 페이지에서 결제하기를 통해 상품을 주문한다.

### 회원 관리
- 일반 사용자의 회원 관리 페이지에선 회원 정보 관리, 주문 관리를 할 수 있다.
- 회원 정보 관리
  - 회원 닉네임 변경
  - 회원 비밀번호 변경
  - 회원 탈퇴
- 주문 관리
  - 현재 주문의 상태를 확인한다.
  - 주문의 이력을 확인한다.