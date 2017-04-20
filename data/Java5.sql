CREATE SCHEMA `as_sof302` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;

CREATE TABLE `as_sof302`.`users` (
  `Username` VARCHAR(30) NOT NULL,
  `Password` VARCHAR(45) NOT NULL,
  `Fullname` VARCHAR(50) NULL,
  PRIMARY KEY (`Username`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

CREATE TABLE `as_sof302`.`departs` (
  `DepartId` VARCHAR(10) NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`DepartId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

CREATE TABLE `as_sof302`.`staffs` (
  `StaffId` VARCHAR(10) NOT NULL,
  `Name` VARCHAR(30) NOT NULL,
  `Gender` VARCHAR(5) NOT NULL,
  `Birthday` DATE NOT NULL,
  `Photo` VARCHAR(60) NOT NULL,
  `Email` VARCHAR(80) NOT NULL,
  `Phone` VARCHAR(11) NOT NULL,
  `Salary` DOUBLE NOT NULL,
  `Notes` LONGTEXT NOT NULL,
  `DepartId` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`StaffId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

ALTER TABLE staffs ADD CONSTRAINT staffs_departs FOREIGN KEY staffs_departs (DepartId)
    REFERENCES departs (DepartId);

CREATE TABLE `as_sof302`.`records` (
  `RecordId` VARCHAR(10) NOT NULL,
  `Type` INT NOT NULL,
  `Reason` VARCHAR(50) NOT NULL,
  `Date` DATE NOT NULL,
  `StaffId` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`RecordId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

ALTER TABLE records ADD CONSTRAINT records_staffs FOREIGN KEY records_staffs (StaffId)
    REFERENCES staffs (StaffId);

