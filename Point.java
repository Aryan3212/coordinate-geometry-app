class Point{
  double x, y;
  Point(double x, double y){
    this.x = x;
    this.y = y;
  }
  double getDistance(Point p){
    return Math.sqrt(Math.pow(x-p.x,2)+Math.pow(y-p.y,2));
  }
}