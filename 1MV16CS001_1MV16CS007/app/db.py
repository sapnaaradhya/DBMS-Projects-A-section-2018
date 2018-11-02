import cx_Oracle

con = cx_Oracle.connect('student/student@//localhost:1521/xe')
# print(con.version)

cur = con.cursor()
result = cur.execute("select * from student")

for i in result:
    print(i)

con.close()
