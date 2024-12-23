import 'package:flutter/material.dart';

void main() {
  runApp(MaterialApp(
    home: Home(),
  ));
}

class Home extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
        decoration: BoxDecoration(
          image: DecorationImage(
            image: AssetImage(
                "fonts/Implementing_Dark_mode_in_Flutter_OG_Image_730d2b1fd7.png"),
            fit: BoxFit.cover,
          ),
        ),
        child: Stack(
          children: [
            // Overlay to enhance text visibility
            Container(
              color: Colors.black
                  .withOpacity(0.5), // Semi-transparent black overlay
            ),
            Padding(
              padding: EdgeInsets.only(top: 100.0, left: 20.0),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: <Widget>[
                  Text(
                    "Welcome to my portfolio",
                    style: TextStyle(
                        fontSize: 24,
                        color: Colors.white,
                        shadows: [
                          Shadow(
                              color: Colors.black54,
                              offset: Offset(1, 1),
                              blurRadius: 4)
                        ]),
                  ),
                  SizedBox(height: 25),
                  Row(
                    children: <Widget>[
                      CircleAvatar(
                        radius: 60.0,
                        backgroundImage: AssetImage("fonts/1687823831071.jpeg"),
                      ),
                      SizedBox(width: 25),
                      Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: <Widget>[
                          Text("Mohamed Yassine Souissi",
                              style:
                                  TextStyle(fontSize: 20, color: Colors.white)),
                          Text("Software Engineer",
                              style:
                                  TextStyle(fontSize: 16, color: Colors.white)),
                        ],
                      ),
                    ],
                  ),
                  SizedBox(height: 25),
                  Text("About Me",
                      style: TextStyle(
                          fontSize: 22,
                          fontWeight: FontWeight.bold,
                          color: Colors.white)),
                  SizedBox(height: 25),
                  Text("Created By Souissi",
                      style: TextStyle(fontSize: 16, color: Colors.white)),
                  SizedBox(height: 20),
                  Column(
                    children: <Widget>[
                      Row(
                        children: <Widget>[
                          Icon(Icons.school, size: 40, color: Colors.white),
                          SizedBox(width: 25),
                          Text("Khaireddine Becha",
                              style:
                                  TextStyle(fontSize: 20, color: Colors.white)),
                        ],
                      ),
                      Row(
                        children: <Widget>[
                          Icon(Icons.computer_rounded,
                              size: 40, color: Colors.white),
                          SizedBox(width: 25),
                          Text("Iset Charguia",
                              style:
                                  TextStyle(fontSize: 20, color: Colors.white)),
                        ],
                      ),
                      Row(
                        children: <Widget>[
                          Icon(Icons.location_pin,
                              size: 40, color: Colors.white),
                          SizedBox(width: 25),
                          Text("Ariana, Tunis",
                              style:
                                  TextStyle(fontSize: 20, color: Colors.white)),
                        ],
                      ),
                      Row(
                        children: <Widget>[
                          Icon(Icons.email, size: 40, color: Colors.white),
                          SizedBox(width: 25),
                          Text("mohamedyassine5678@gmail.com",
                              style:
                                  TextStyle(fontSize: 20, color: Colors.white)),
                        ],
                      ),
                      Row(
                        children: <Widget>[
                          Icon(Icons.phone, size: 40, color: Colors.white),
                          SizedBox(width: 25),
                          Text("+21655299606",
                              style:
                                  TextStyle(fontSize: 20, color: Colors.white)),
                        ],
                      ),
                    ],
                  ),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }
}
