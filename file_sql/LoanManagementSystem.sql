create database IF NOT EXISTS loan_processing_system CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE loan_processing_system;

create table Authorities
(
    	Id int PRIMARY KEY,
    	Name varchar(50)
);

create table Account
(
   	Id         int PRIMARY KEY AUTO_INCREMENT,
    	AuthId	int,
    	Name varchar(50),
    	Password varchar(100),
	Address text,
	Phone varchar(20),
	Email varchar(50),
	Gender tinyint,
	DOB Date,
	IdentityCard varchar(50),
	Status tinyint,
	
	CONSTRAINT FK_Account_Authorities FOREIGN KEY(AuthId) REFERENCES Authorities(Id)
);

create table Customer
(
   	Id         int PRIMARY KEY AUTO_INCREMENT,
    	Name varchar(50),
	Address text,
	Phone varchar(20),
	Email varchar(50),
	Gender tinyint,
	DOB Date,
	Salary float,
	Job varchar(50),
	Company varchar(50),
	IdentityCard varchar(50),
	Status tinyint
);

create table LoanType
(
    	Id         int PRIMARY KEY AUTO_INCREMENT,
    	Interest	float,
    	Name	varchar(50),
	Description text,
	Status tinyint
);


create table PaymentType
(
    	Id         int PRIMARY KEY AUTO_INCREMENT,
    	Name	varchar(50)
);


create table PaymentMethod
(
    	Id         int PRIMARY KEY AUTO_INCREMENT,
    	Name	varchar(50)
);


create table Loan
(
    	Id         int PRIMARY KEY AUTO_INCREMENT,
    	LoanTypeId	int,
	AccountId int,
		CustomerId int,
    	PaymentTypeId	int,
   	Amount float(53),
	Period int,
	CreateDate date,
	DisbursementDate date,
	Duration int,
	EndDate date,
	Interest float,
	Description text,
	Status int DEFAULT 0,

	CONSTRAINT FK_Loan_LoanType FOREIGN KEY(LoanTypeId) REFERENCES LoanType(Id),
	CONSTRAINT FK_Loan_Account FOREIGN KEY(AccountId) REFERENCES Account(Id),
	CONSTRAINT FK_Loan_Customer FOREIGN KEY(CustomerId) REFERENCES Customer(Id),
	CONSTRAINT FK_Loan_PaymentType FOREIGN KEY(PaymentTypeId) REFERENCES PaymentType(Id)
);



create table Fine
(
    	Id         int PRIMARY KEY AUTO_INCREMENT,
    	FineInterest	float,
		`Min` float(53),
		`Max` float(53),
	Description text,
	Status tinyint
);

create table LoanAndFineHistory
(
    	Id         int PRIMARY KEY AUTO_INCREMENT,
    	LoanId	int,
    	FineId	int,
	PaymentMethodId	int,
	PaymentAmount float(53),
	AmountLeft float(53),
	DueDate date,
	FineInterest float,
	FineOverDays int,
	FineAmount float(53),
	PaymentDate Date,
	Description text,
	Status tinyint,
   	Amount float(53),
	
	CONSTRAINT FK_LoanAndFineHistory_Loan FOREIGN KEY(LoanId) REFERENCES Loan(Id),
	CONSTRAINT FK_LoanAndFineHistory_Fine FOREIGN KEY(FineId) REFERENCES Fine(Id),
	CONSTRAINT FK_LoanAndFineHistory_PaymentMethod FOREIGN KEY(PaymentMethodId) REFERENCES PaymentMethod(Id)
);


insert into Authorities(Id, Name)
values (1, 'Staff'),
 	(2, 'Admin');


-- DEFAULT PASS: 123).
insert into Account(AuthId, Name, Password, Address, Phone, Email, Gender, DOB, IdentityCard, Status)
values (2, 'Admin', '$2a$10$mgY9/7i9MPQH8NoTImoGu.JK4G1FKCUZNjECZbyj3EgmiXQqCrC2W','217 Thich Quang Duc, ward 04, Phu Nhuan Dist, HCM City', '098773230', 'admin@gmail.com', 0, '1991-07-08', '245207565', 1),
(1, 'Nguyen Minh Thanh', '$2a$10$mgY9/7i9MPQH8NoTImoGu.JK4G1FKCUZNjECZbyj3EgmiXQqCrC2W','198 No Trang Long, ward 12, Binh Thanh Dist, HCM City', '0987721223', 'minhthanh@gmail.com', 0, '1991-07-08', '245207565', 1),
(1, 'Le Co', '$2a$10$mgY9/7i9MPQH8NoTImoGu.JK4G1FKCUZNjECZbyj3EgmiXQqCrC2W','183 Huynh Tan Phat, ward 12, Dist 7, HCM City', '098775464', 'leco@gmail.com', 0, '1993-07-08', '654852354', 1),
(1, 'Nguyen Tri Quang', '$2a$10$mgY9/7i9MPQH8NoTImoGu.JK4G1FKCUZNjECZbyj3EgmiXQqCrC2W','58 Street, ward 12, Dist 7, HCM City', '098775464', 'triquang@gmail.com', 0, '1994-07-08', '654852354', 1),
(1, 'Thien An', '$2a$10$mgY9/7i9MPQH8NoTImoGu.JK4G1FKCUZNjECZbyj3EgmiXQqCrC2W','183 Huynh Tan Phat, ward 12, Dist 7, HCM City', '098775464', 'thienan@gmail.com', 0, '2000-07-08', '654852354', 1);

 
insert into Customer(Name, Address, Phone, Email, Gender, DOB, Salary, Job, Company, IdentityCard, Status)
values ('Hong That Cong', '48 Phan Dinh Phung, ward 12, Phu Nhuan Dist, HCM City', '098772330', 'thatcon@gmail.com', 0, '1991-07-08', 30000000, 'IT', 'ABC Co. Ltd.', '245207565', 1),
('Hoang Lao Ta', '183 Nguyen Dinh Chieu, ward 12, Dist 3, HCM City', '098775464', 'laota@gmail.com', 0, '1993-07-08', 10000000, 'Shipper', 'Grab Co. Ltd.', '654852354', 1),
('Chu Ba Thong', '58 Nguyen Van Thu, Dakao ward, Dist 1, HCM City', '098775464', 'chuchu@gmail.com', 0, '1994-07-08', 10000000, 'Shipper', 'Grab Co. Ltd.', '654852354', 1);

 
insert into LoanType(Interest, Name, Status, Description)
values  (0.1, 'Home Loan', 1, ''),
 	(0.13, 'Vehicle Loan', 1, ''),
 	(0.18, 'Personal Loan', 1, ''),
 	(0.05, 'Educational', 1, '');
 
insert into PaymentType(Name)
values ('Root: Month - Interest: Month');

insert into PaymentMethod(Name)
values ('Cash'),
('ATM Card'),
('Master Card'),
('Momo'),
('Zalopay'),
('Paypal');


insert into Loan(LoanTypeId, AccountId, PaymentTypeId, CustomerId, Amount, Period, CreateDate, DisbursementDate, EndDate, Duration, Interest, Status, Description)
values (3, 1, 1, 1, 500000000,  1, '2020-05-29', '2020-06-02','2021-06-02', 12, 0.13, 1, ''),
(2, 2, 1, 2, 1500000000, 2, '2020-08-04', '2020-08-07', '2022-08-07', 24, 0.1, 1, ''),
(4, 1, 1, 1, 200000000, 1, '2021-06-21', '2021-06-04', '2026-06-04', 60, 0.18, 1, ''),
(2, 4, 1, 1, 500000000, 1, '2021-07-29', '2021-08-01', '2023-08-01', 24, 0.1, 0, ''),
(3, 2, 1, 2, 100000000, 3, '2021-07-29', '2021-08-01', '2022-08-01', 12, 0.13, 2, ''),
(1, 3, 1, 3, 5000000000, 3, '2021-07-29', '2021-08-01','2024-08-01', 36, 0.13, 0, '');


insert into Fine(FineInterest, `Min`, `Max`, Status, Description)
values (0.02, 1, 5000, 1, ''),
 	(0.05, 5001, 20000, 1, ''),
 	(0.08, 20001, NULL, 1, '');

	
insert into LoanAndFineHistory(LoanId, PaymentMethodId, PaymentDate, PaymentAmount, AmountLeft, DueDate, Status, Description, Amount)
values (1, 1, '2020-09-05', 500000, 499950000, '2020-09-02', 1, '', 500000000),
(2, 1, '2020-09-07', 1500000, 1499500000, '2020-09-07', 1, '', 1500000000);

insert into LoanAndFineHistory(LoanId, FineId, PaymentMethodId, PaymentDate, PaymentAmount, AmountLeft, DueDate, FineInterest, FineOverDays, FineAmount, Status, Description, Amount)
values (1, 1, 1, '2020-09-05', 500000, 499950000, '2020-09-02', 0.02, 3, 100000, 1, '', 500000000),
(2, 3, 3, '2020-10-09', 1450000, 1498150000, '2020-10-07', 0.08, 2, 116000, 1, '', 1500000000);



