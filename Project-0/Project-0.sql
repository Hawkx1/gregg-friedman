#USE 'Project-0';

DROP TABLE IF EXISTS logins;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS customers_to_accounts;
DROP TABLE IF EXISTS accounts;

CREATE TABLE accounts
(
	account_id INT AUTO_INCREMENT,
	balance DECIMAL(10,2),
	INDEX (account_id),
	CONSTRAINT accounts_pk PRIMARY KEY (account_id)
);

CREATE TABLE customers_to_accounts
(
	junction_id INT AUTO_INCREMENT,
	customer_id INT NOT NULL,
	account_id	INT NOT NULL,
	INDEX (customer_id),
	INDEX(account_id),
	CONSTRAINT customers_to_accounts_pk PRIMARY KEY (junction_id),
	CONSTRAINT cta_fk FOREIGN KEY (account_id) REFERENCES accounts(account_id)
);

CREATE TABLE customers
(
	customer_id INT AUTO_INCREMENT,
	first_name 	VARCHAR(100),
	last_name	VARCHAR(100),
	INDEX (customer_id),
	CONSTRAINT customers_pk PRIMARY KEY (customer_id),
	CONSTRAINT customers_junction_fk FOREIGN KEY (customer_id) REFERENCES customers_to_accounts(customer_id)
);

CREATE TABLE logins
(
	customer_id INT NOT NULL,
	user_name 	VARCHAR(100),
	password	VARCHAR(100),
	INDEX (customer_id),
	CONSTRAINT logins_pk PRIMARY KEY (customer_id),
	CONSTRAINT logins_customers FOREIGN KEY(customer_id) REFERENCES customers(customer_id)
);

INSERT INTO accounts (account_id, balance) VALUES (1001, 1500.50);
INSERT INTO accounts (account_id, balance) VALUES (1002, 2780.25);
INSERT INTO accounts (account_id, balance) VALUES (1003, 150);
INSERT INTO accounts (account_id, balance) VALUES (1004, 13.33);
INSERT INTO accounts (account_id, balance) VALUES (1005, 100000.01); 
INSERT INTO accounts (account_id, balance) VALUES (1006, 12345.67);
INSERT INTO accounts (account_id, balance) VALUES (1007, 1345.67);

INSERT INTO customers_to_accounts (customer_id, account_id) VALUES (1, 1001);
INSERT INTO customers_to_accounts (customer_id, account_id) VALUES (1, 1002);
INSERT INTO customers_to_accounts (customer_id, account_id) VALUES (2, 1003);
INSERT INTO customers_to_accounts (customer_id, account_id) VALUES (2, 1004);
INSERT INTO customers_to_accounts (customer_id, account_id) VALUES (3, 1005);
INSERT INTO customers_to_accounts (customer_id, account_id) VALUES (4, 1006);
INSERT INTO customers_to_accounts (customer_id, account_id) VALUES (5, 1007);

INSERT INTO customers (customer_id, first_name, last_name) VALUES (1, "Jason", "Smith");
INSERT INTO customers (customer_id, first_name, last_name) VALUES (2, "Amanda", "Smith");
INSERT INTO customers (customer_id, first_name, last_name) VALUES (3, "John", "Cross");
INSERT INTO customers (customer_id, first_name, last_name) VALUES (4, "Marty", "Gras");
INSERT INTO customers (customer_id, first_name, last_name) VALUES (5, "Jason", "Lastname");

INSERT INTO logins VALUES (1,"Jsmith", "123");
INSERT INTO logins VALUES (2,"Asmith", "456");
INSERT INTO logins VALUES (3,"Jcross", "789");
INSERT INTO logins VALUES (4,"Mgras", "135");
INSERT INTO logins VALUES (5,"Jlastname", "246");