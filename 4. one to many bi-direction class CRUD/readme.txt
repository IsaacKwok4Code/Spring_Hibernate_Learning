one instructor to one instructor_detail

instructor has
id -> primary key
first name
last name
email
instructor_detail_id -> foreign key

instructor_detail
id -> primary key
youtube_channel
hobby
instructor -> using mappedBy to trigger hibernate to 
look at the instructor class or find the corresponding InstructorDetail property. There is a joinColumn to tell hibernate.