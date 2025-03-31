package Centipede;

public class Centipede {
    Segment head;

    int dx, dy;

    int horizontalDir; //if you are moving left or right

    int verticalMoveCount = 0; //how far you moved during turns

    int verticalLim = 20; //how many px to move down each time we switch rows

    public Centipede(int startX, int startY, int length) {
        this.dx = 7; //centipede's xspeed
        this.dy = 0; //centipede's yspeed
        this.horizontalDir = 1; //+1 for right and -1 for left

        //building linked segments
        head = new Segment(startX, startY);
        Segment current = head;

        for (int i = 1; i < length; i++) {
            current.next = new Segment(startX - (i*15), startY);
            current = current.next;
        }
        }

        public void move() {
            if(head == null) return;

            //save old head position
            int prevX = head.x;
            int prevY = head.y;

            //move head
            head.x = dx;
            head.y = dy;

            //move body
            Segment current = head.next;
            while (current != null) {
                int tempX = current.x;
                int tempY = current.y;
                current.x = prevX;
                current.y = prevY;
                prevX = tempX;
                prevY = tempY;
                current = current.next;
            }
        }

        public void CheckAndTurn(int panelWidth, int panelHeight) {
            if (head == null) return;

            //centipede's approx. width

            int segSize = 15;
            int rBound = panelWidth - segSize;
            int lBound = 0;

            // 1. if we're moving horizontally (dy == 0)
            if (dy == 0){
                if(horizontalDir == 1 && head.x >= rBound) {
                    //starts moving down
                    dx = 0;
                    dy = 7;
                    verticalMoveCount = 0;
                }
                else if (horizontalDir == -1 && head.x <= lBound) {
                    dx = 0;
                    dy = 7;
                    verticalMoveCount = 0;
                }
            }
            else {
                verticalMoveCount += Math.abs(dy);
                if (verticalMoveCount >= verticalLim) {
                    //flip horizontally and switch horizontal direction to -1
                    horizontalDir = -horizontalDir;
                    //if we are going right, now go left and vice versa
                    dx = 7 * -horizontalDir;
                    dy = 0;

                }
            }
        }
        public void split(Segment splitPoint) {
            if(splitPoint == head) {
                head = null;
            }
            else {
                Segment current = head;
                while( current != null && current.next != splitPoint){
                    current = current.next;
                }
                if(current != null) {
                    current.next = null; 
                }
            }
        }
    }

