using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Xml;
using System.Xml.Linq;

namespace WindowsFormsApp1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();

            cbNum.SelectedIndex = 0;

        }

        private void btnSubmit_Click(object sender, EventArgs e)
        {

            if (cbNum.SelectedIndex != 0) 
            {

                int numJokes = cbNum.SelectedIndex;
                lblJokes.Text = numJokes + " jokes selected.";

                var xml = XDocument.Load("jokes.xml");

                for (int i = 0; i < numJokes; i++)
                {

                    Random rand = new Random();
                    int randNum = rand.Next(25);

                    var query = from c in xml.Root.Descendants("joke")
                            where (int)c.Attribute("id") == randNum
                            select c.Element("setup").Value + "\n" +
                            c.Element("punchline").Value;

                    foreach (string joke in query)
                        lblJokes.Text += "\n\nJoke " + (i + 1) + ":\n" + joke;

                    System.Threading.Thread.Sleep(100);

                } 

                lblJokes.Text += "\n\nThanks for hearing bad jokes!";

            } else
            {

                lblJokes.Text = "Oh. I see how it is.";

            }
            

        }

        private void cbNum_SelectedIndexChanged(object sender, EventArgs e)
        {

        }
    }
}

// Old code:
//XmlTextReader reader = new XmlTextReader("jokes.xml");
/*
 * while (reader.Read())
 * {
 * if (numJokes > 0)
 * {
 * lblJokes.Text += "Jokes!\n";
 * numJokes--;
 * }
 * }
 */
