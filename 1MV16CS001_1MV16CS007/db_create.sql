create table teacher(
	dept_name varchar(10),
	f_name varchar(10),
	m_name varchar(10),
	l_name varchar(10),
	teacher_id varchar(10),
	Primary key(teacher_id),
	foreign key(dept_name)references dept(dept_name)

	);
create table teacher_course(
	course_id varchar(10),
	section_id varchar(10),
	sem number(1),
	year number(4),
	teacher_id varchar(10),
	primary key (course_id,section_id,sem,year,teacher_id),
	foreign key (teacher_id) references teacher(teacher_id),
	foreign key(course_id,section_id,sem,year) references (course_id,section_id,sem,year)
	);
create table section(
	building number(2),
	room_no number(3),
	year number(4),
	sem number(1);
	section_id varchar(10),
	course_id varchar(10),
	timeslot_id varchar(10),
	primary key(course_id,section_id,sem),
	foreign key(course_id) references course_info(course_id),
	foreign key(building,room_no) references classroom(building,room_no)
	);
create table timeslot(
	timeslot_id  varchar(10),
	day char(3),
	start_hour number(2),
	start_min number(2),
	end_hour number(2),
	end_min number(2),
	primary key(timeslot_id,day,start_hour,start_min),

	);
create table classroom(
	capacity number(3),
	room_no number(3),
	building number(2),
	primary key(building,room_no)

	);
create table course_info(
	course_id varchar(10),
	dept_name varchar(10),
	title varchar(10),
	no_of_hours number(2),
	credits varchar(10),
	primary key (course_id),
	foreign key(dept_name) references dept(dept_name)
	);
create table dept(
	dept_name varchar(10),
	building number(2),
	primary key(dept_name)
	);
create table student(
	stud_id varchar(10),
	name varchar(10),
	dept_name varchar(10),
	primary key(stud_id),
	foreign key(dept_name) references dept(dept_name)

	);
create table student_course(
	stud_id varchar(10),
	course_id varchar(10),
	year number(4),
	section_id varchar(10),
	sem number(1),
	grade varchar(2),
	primary key(stud_id,course_id,section_id,sem,year),
	foreign key(course_id,section_id,sem,year) references section(course_id,section_id,sem,year),
	foreign key(stud_id) references student(stud_id)
	);
create table local_guardian(
	teacher_id varchar(10),
	stud_id varchar(10),
	primary key(stud_id),
	foreign key(stud_id) references student (stud_id),
	foreign key(teacher_id) references teacher(teacher_id)
	);
