#version 330 core

layout (location = 0) out vec4 color;

in DATA
{
	vec2 tc;
	vec3 position;
} fs_in;

uniform vec2 bird;
uniform sampler2D tex;
uniform int top;

void main()
{
//	if (top == 1)
//		fs_in.tc.y = 1.0 - fs_in.tc.y;

    vec2 tc2;
    tc2.x = fs_in.tc.x;
    tc2.y = fs_in.tc.y;
    if (top == 1)
    	tc2.y = 1.0 - tc2.y;


	color = texture(tex, tc2);
	if (color.w < 1.0)
		discard;
	color *= 2.0 / (length(bird - fs_in.position.xy) + 1.5) + 0.5;
	color.w = 1.0;
}