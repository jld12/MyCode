namespace Random
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            this.bindingSource1 = new System.Windows.Forms.BindingSource(this.components);
            this.JokeButton = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.JokeLabel = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.bindingSource1)).BeginInit();
            this.SuspendLayout();
            // 
            // JokeButton
            // 
            this.JokeButton.Location = new System.Drawing.Point(411, 12);
            this.JokeButton.Name = "JokeButton";
            this.JokeButton.Size = new System.Drawing.Size(156, 23);
            this.JokeButton.TabIndex = 0;
            this.JokeButton.Text = "Tell Me a Joke!";
            this.JokeButton.UseVisualStyleBackColor = true;
            this.JokeButton.Click += new System.EventHandler(this.JokeButton_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 16F);
            this.label1.Location = new System.Drawing.Point(12, 9);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(207, 26);
            this.label1.TabIndex = 1;
            this.label1.Text = "Dad Joke Generator";
            // 
            // JokeLabel
            // 
            this.JokeLabel.AutoSize = true;
            this.JokeLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 14F);
            this.JokeLabel.Location = new System.Drawing.Point(14, 82);
            this.JokeLabel.Name = "JokeLabel";
            this.JokeLabel.Size = new System.Drawing.Size(15, 24);
            this.JokeLabel.TabIndex = 2;
            this.JokeLabel.Text = " ";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(579, 240);
            this.Controls.Add(this.JokeLabel);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.JokeButton);
            this.Name = "Form1";
            this.Text = "Dad Joke Generator";
            ((System.ComponentModel.ISupportInitialize)(this.bindingSource1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.BindingSource bindingSource1;
        private System.Windows.Forms.Button JokeButton;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label JokeLabel;
    }
}

