BEGIN TRANSACTION;

DROP TABLE IF EXISTS task_type, employee, client, task, task_employee, task_client CASCADE;

CREATE TABLE task_type (
	task_type_id serial,
	task_type_name varchar(40) NOT NULL,
	CONSTRAINT PK_task_type PRIMARY KEY (task_type_id)
);

CREATE TABLE employee (
	employee_id serial,
	first_name varchar(40) NOT NULL,
	last_name varchar(40) NOT NULL,
	title_role varchar(40) NOT NULL,
	email_address varchar(100) NOT NULL,
	CONSTRAINT PK_employee PRIMARY KEY (employee_id)
);

CREATE TABLE client (
	client_id serial,
	client_name varchar(100) NOT NULL,
	phone_number varchar(10),
	email_address varchar(100),
	CONSTRAINT PK_client PRIMARY KEY (client_id)
);

CREATE TABLE task (
	task_id serial,
	task_title varchar(100) NOT NULL,
	description varchar(200),
	notes text,
	start_date date,
	end_date date,
	hyperlink varchar(200),
	task_type_id int NOT NULL,
	CONSTRAINT PK_task PRIMARY KEY (task_id),
	CONSTRAINT FK_task_task_type FOREIGN KEY (task_type_id) REFERENCES task_type (task_type_id)
);

CREATE TABLE task_employee (
	task_id int NOT NULL,
	employee_id int NOT NULL,
	has_reminder boolean NOT NULL,
	created_by int NOT NULL,
	completed_by int,
	CONSTRAINT PK_task_employee PRIMARY KEY (task_id, employee_id),
	CONSTRAINT FK_task_employee_task FOREIGN KEY (task_id) REFERENCES task (task_id),
	CONSTRAINT FK_task_employee_employee FOREIGN KEY (employee_id) REFERENCES employee (employee_id),
	CONSTRAINT FK_task_employee_created_by FOREIGN KEY (created_by) REFERENCES employee (employee_id),
	CONSTRAINT FK_task_employee_completed_by FOREIGN KEY (completed_by) REFERENCES employee (employee_id)
);

CREATE TABLE task_client (
	task_id int NOT NULL,
	client_id int NOT NULL,
	CONSTRAINT PK_task_client PRIMARY KEY (task_id, client_id),
	CONSTRAINT FK_task_client_task FOREIGN KEY (task_id) REFERENCES task (task_id),
	CONSTRAINT FK_task_client_client FOREIGN KEY (client_id) REFERENCES client (client_id)
);

COMMIT;
