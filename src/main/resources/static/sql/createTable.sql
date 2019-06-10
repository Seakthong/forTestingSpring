create table tblcategories ( id int primary key, name varchar(30) not null);
create table tblarticles ( id int primary key, title varchar(30) not null, description text not null, author varchar(30) not null, create_date varchar(30), thumbnail varchar(30) not null, category_id int references tblcategories(id) on DELETE cascade  on update cascade )
