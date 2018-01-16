using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Random
{
    public partial class Form1 : Form
    {


        public Form1()
        {
            InitializeComponent();
        }

        private void JokeButton_Click(object sender, EventArgs e)
        {
            System.Random rand = new System.Random();
            int randNum = rand.Next(20);

            switch (randNum)
            {
                case 0:
                    JokeLabel.Text = "Why can't you hear a pterodactyl go to the bathroom?"
                        + "\nBecause the p is silent!";
                    break;

                case 1:
                    JokeLabel.Text = "My ex-wife still misses me..."
                        + "\nBut her aim is getting better!";
                    break;

                case 2:
                    JokeLabel.Text = "Velcro..."
                        + "\nWhat a ripoff!";
                    break;

                case 3:
                    JokeLabel.Text = "Is pesticide good for crop-eating bugs?"
                        + "\nNo--it kills them!";
                    break;

                case 4:
                    JokeLabel.Text = "How do you find Will Smith in the snow?"
                        + "\nLook for Fresh Prints!";
                    break;

                case 5:
                    JokeLabel.Text = "Don't trust stairs..."
                        + "\nThey're always up to something!";
                    break;

                case 6:
                    JokeLabel.Text = "I love the ground."
                        + "\nIt's always there for me when I'm down!";
                    break;

                case 7:
                    JokeLabel.Text = "A group of mimes attacked a pedestrian..."
                        + "\nTheir crimes were unspeakable!";
                    break;

                case 8:
                    JokeLabel.Text = "What garb do men from Thailand wear to work?"
                        + "\nA suit and Thai!";
                    break;

                case 9:
                    JokeLabel.Text = "What do houses wear?"
                        + "\nAddress!";
                    break;

                case 10:
                    JokeLabel.Text = "A woman lost a marathon to a Sister..."
                        + "\nBut she was second to nun!";
                    break;

                case 11:
                    JokeLabel.Text = "Why did the scarecrow make the Dean's List?"
                        + "\nIt was out standing in its field!";
                    break;

                case 12:
                    JokeLabel.Text = "Why does a chicken coop have 2 doors?"
                        + "\nIf it had 4, it would be a chicken sedan!";
                    break;

                case 13:
                    JokeLabel.Text = "What happened when the priest blessed an avacado?"
                        + "\nHe made guaca-holy!";
                    break;

                case 14:
                    JokeLabel.Text = "I looked in the cupboard for some pita..."
                        + "\nBut we had nhan!";
                    break;

                case 15:
                    JokeLabel.Text = "I was going to watch the new Paddington movie..."
                        + "\nBut I could bearly handle the first one!";
                    break;

                case 16:
                    JokeLabel.Text = "I new scholarly article about a study involving fish came out..."
                        + "\nIt's pier reviewed!";
                    break;

                case 17:
                    JokeLabel.Text = "What's a good way to invest in bonds?"
                        + "\nBuy a box set of all the movies!";
                    break;

                case 18:
                    JokeLabel.Text = "Why do mermaids wear seashells?"
                        + "\nThey can't fit in b-shells!";
                    break;

                case 19:
                    JokeLabel.Text = "Why did the scientist compare the behavior of two beetles?"
                        + "\nTo find the lesser of two weevils!";
                    break;

                default:
                    JokeLabel.Text = "What do you call a knockoff sodoku puzzle?"
                        + "\nPseudoku!";
                    break;
            }

        }
    }
}
