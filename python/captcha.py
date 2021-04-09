from PIL import Image, ImageDraw, ImageFont
from random import randint

# characters
minmax = (4, 6)

# character spacing
chrspace = 35

# chrspace randomization
chrspacerng = 6

# width/height of image
wl = (300, 90)

# font size
fntsz = 60


image = Image.new("RGBA", wl, (0,0,0,0))

fnt = ImageFont.truetype("./Mom«t___.ttf", fntsz)

for i in range(randint(minmax[0], minmax[1])): 
    ImageDraw.Draw(image).text(((chrspace + (chrspace*i))+(randint(-15, 12)), 10+randint(-chrspacerng, chrspacerng)), 'abcdefghijklmnopqrstuvwxyz'[randint(0, 25)], spacing=-150, font=fnt, fill=(randint(0, 255), randint(0, 255), randint(0, 255)))
    image = image.rotate(randint(-4,4))



# do something with the image lol

image.show()
image.save("./image.png")
