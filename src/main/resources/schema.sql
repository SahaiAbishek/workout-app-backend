--create database users for application
create table app_users
(
	user_id integer auto_increment,
	username varchar(1000),
 	email varchar(1000),
	password text, 
	primary key(user_id)
);

create table category
(
	category_id integer auto_increment,
	name varchar(1000),
	primary key(category_id),
);

create table workouts
(
	workout_id integer auto_increment,
	title varchar(1000),
 	note varchar(5000),
	calories varchar(100), 
	duration integer,
	user_id integer,
	category_id integer,
	primary key(workout_id),
	FOREIGN KEY (`user_id`) REFERENCES `app_users` (`user_id`),
	FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`)
);


