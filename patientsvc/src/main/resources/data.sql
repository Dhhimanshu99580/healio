CREATE TABLE IF NOT EXISTS patient (
    id UUID PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    address VARCHAR(255) NOT NULL,
    phone VARCHAR(20) NOT NULL UNIQUE,
    date_of_birth DATE NOT NULL
);

INSERT INTO patient (id, name, email, address, phone, date_of_birth) VALUES
('1e2a3b4c-5d6e-7f8a-9b0c-1d2e3f4a5b6c', 'Rohan Sharma', 'rohan.sharma@example.com', '12 MG Road, Mumbai', '9876543210', '1990-03-15'),
('2f3b4c5d-6e7f-8a9b-0c1d-2e3f4a5b6c7d', 'Ananya Gupta', 'ananya.gupta@example.com', '34 Park Street, Kolkata', '8765432109', '1988-07-22'),
('3a4c5d6e-7f8a-9b0c-1d2e-3f4a5b6c7d8e', 'Vikram Singh', 'vikram.singh@example.com', '56 Residency Road, Bangalore', '7654321098', '1992-01-10'),
('4b5d6e7f-8a9b-0c1d-2e3f-4a5b6c7d8e9f', 'Priya Menon', 'priya.menon@example.com', '78 Marine Drive, Mumbai', '6543210987', '1995-11-05'),
('5c6e7f8a-9b0c-1d2e-3f4a-5b6c7d8e9f0a', 'Arjun Patel', 'arjun.patel@example.com', '90 Residency Road, Ahmedabad', '5432109876', '1987-08-30'),
('6d7f8a9b-0c1d-2e3f-4a5b-6c7d8e9f0a1b', 'Isha Reddy', 'isha.reddy@example.com', '101 MG Road, Hyderabad', '4321098765', '1993-04-12'),
('7e8a9b0c-1d2e-3f4a-5b6c-7d8e9f0a1b2c', 'Rahul Verma', 'rahul.verma@example.com', '202 Park Street, Delhi', '3210987654', '1989-09-18'),
('8f9b0c1d-2e3f-4a5b-6c7d-8e9f0a1b2c3d', 'Sneha Joshi', 'sneha.joshi@example.com', '303 Brigade Road, Bangalore', '2109876543', '1991-06-07'),
('9a0c1d2e-3f4a-5b6c-7d8e-9f0a1b2c3d4e', 'Aditya Kapoor', 'aditya.kapoor@example.com', '404 MG Road, Pune', '1098765432', '1986-12-21'),
('0b1d2e3f-4a5b-6c7d-8e9f-0a1b2c3d4e5f', 'Neha Choudhary', 'neha.choudhary@example.com', '505 Park Street, Lucknow', '9988776655', '1994-02-14'),
('1c2e3f4a-5b6c-7d8e-9f0a-1b2c3d4e5f6a', 'Karan Jain', 'karan.jain@example.com', '606 Residency Road, Jaipur', '8877665544', '1990-05-20'),
('2d3f4a5b-6c7d-8e9f-0a1b-2c3d4e5f6a7b', 'Tanya Iyer', 'tanya.iyer@example.com', '707 Marine Drive, Chennai', '7766554433', '1987-10-09'),
('3e4a5b6c-7d8e-9f0a-1b2c-3d4e5f6a7b8c', 'Siddharth Nair', 'siddharth.nair@example.com', '808 Park Street, Kochi', '6655443322', '1992-08-27'),
('4f5b6c7d-8e9f-0a1b-2c3d-4e5f6a7b8c9d', 'Pooja Rathi', 'pooja.rathi@example.com', '909 Brigade Road, Bangalore', '5544332211', '1995-03-30'),
('5a6c7d8e-9f0a-1b2c-3d4e-5f6a7b8c9d0e', 'Vivek Desai', 'vivek.desai@example.com', '111 MG Road, Surat', '4433221100', '1988-07-19'),
('6b7d8e9f-0a1b-2c3d-4e5f-6a7b8c9d0e1f', 'Anjali Bhatia', 'anjali.bhatia@example.com', '222 Park Street, Delhi', '3322110099', '1991-11-11'),
('7c8e9f0a-1b2c-3d4e-5f6a-7b8c9d0e1f2a', 'Manish Kumar', 'manish.kumar@example.com', '333 Residency Road, Lucknow', '2211009988', '1993-06-25'),
('8d9f0a1b-2c3d-4e5f-6a7b-8c9d0e1f2a3b', 'Ritika Sharma', 'ritika.sharma@example.com', '444 Marine Drive, Mumbai', '1100998877', '1989-01-15'),
('9e0a1b2c-3d4e-5f6a-7b8c-9d0e1f2a3b4c', 'Amitabh Singh', 'amitabh.singh@example.com', '555 Brigade Road, Bangalore', '9988112233', '1994-09-05'),
('0f1b2c3d-4e5f-6a7b-8c9d-0e1f2a3b4c5d', 'Simran Kaur', 'simran.kaur@example.com', '666 MG Road, Delhi', '8877223344', '1990-12-12');
