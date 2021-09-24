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