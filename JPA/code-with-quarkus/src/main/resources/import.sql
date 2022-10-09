insert into Job(job_title, permission) values('Chef', true);

insert into Employee(username, first_name, last_name, password, job_id) values('JosefC', 'Josef', 'Cagitz', 'password123', 1);

insert into Customer(first_name, last_name, email, password, telephoneNumber) values('Fabian', 'Maar', 'fabian@maar.com', '123', '123456789');

insert into Room(room_name, summer_winter) values('Raum 1', 'Winter');

insert into TableEntity(seats, room_id) values(4, 1);

insert into Reservation(employee_id, customer_id, customer_name, reservation_time, reservation_date, reservation_timestamp, person_amount, tableno) values(1, 1, 'Maar', 1, '2022-10-09', current_timestamp, 4, 1);