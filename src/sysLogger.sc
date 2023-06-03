;;; Sierra Script 1.0 - (do not remove this comment)
(script# 952)
(include sci.sh)
(use Main)
(use Print)
(use PolyPath)
(use Obj)

(public
	sysLogger 0
)

(local
	local0
)
(procedure (localproc_0010 param1 param2 param3 &tmp [temp0 40] temp40 temp41)
	(Format @temp0 952 0 param2)
	(FileIO fiWRITE_STRING local0 @temp0)
	(= temp0 0)
	(switch param1
		(1
			(StrCpy @temp0 (if param3 else {}))
		)
		(2 (Format @temp0 952 1 param3))
		(3 (Format @temp0 952 2 param3))
		(4 (Format @temp0 952 3 param3))
		(5
			(if param3 (proc921_2 @temp0 66 param3 999))
			(= temp41 (StrLen @temp0))
		)
		(6
			(= temp40 (GetTime 2))
			(Format
				@temp0
				952
				4
				(>> temp40 $000b)
				(& (>> temp40 $0005) $003f)
				(* (& temp40 $001f) 2)
			)
		)
		(7
			(= temp40 (GetTime 3))
			(Format
				@temp0
				952
				5
				(& (>> temp40 $0005) $000f)
				(& temp40 $001f)
				(+ 80 (>> temp40 $0009))
			)
		)
	)
	(StrCat @temp0 {\0D\n})
	(FileIO fiWRITE_STRING local0 @temp0)
	(return temp41)
)

(instance sysLogger of Code
	(properties)
	
	(method (doit &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 [temp8 40] [temp48 30] [temp78 30] [temp108 30] [temp138 20] [temp158 40] [temp198 40] [temp238 40] [temp278 40] [temp318 40] [temp358 40])
		(asm
			lag      gFont_2
			sat      temp7
			ldi      999
			sag      gFont_2
			ldi      0
			sat      temp358
			sat      temp318
			sat      temp278
			sat      temp238
			sat      temp198
			sat      temp158
			sat      temp108
			sat      temp78
			sat      temp8
			pushi    0
			pushi    1
			lea      @global42
			push    
			callk    StrLen,  2
			eq?     
			sat      temp4
			bnt      code_01c2
code_017b:
			pushi    0
			pushi    1
			lea      @temp78
			push    
			callk    StrLen,  2
			lt?     
			bnt      code_018b
			pprev   
			ldi      19
			lt?     
code_018b:
			not     
			bnt      code_01b3
			pushi    #font
			pushi    1
			pushi    999
			pushi    198
			pushi    1
			lofsa    {Enter drive letter, path, and your name\n(no extension, max 40 characters)}
			push    
			pushi    200
			pushi    4
			lea      @temp78
			push    
			pushi    40
			pushi    0
			pushi    20
			pushi    110
			pushi    0
			class    Print
			send     28
			jmp      code_017b
code_01b3:
			pushi    3
			lea      @global42
			push    
			lea      @temp78
			push    
			pushi    40
			callk    StrCpy,  6
code_01c2:
			pushi    4
			lea      @temp78
			push    
			pushi    952
			pushi    6
			lea      @global42
			push    
			callk    Format,  8
			pushi    65535
			pushi    3
			pushi    0
			lea      @temp78
			push    
			pushi    1
			callk    FileIO,  6
			sal      local0
			ne?     
			bnt      code_020d
			pushi    4
			pushi    5
			lea      @temp138
			push    
			pushi    80
			lsl      local0
			callk    FileIO,  8
			pushi    4
			pushi    5
			lea      @temp48
			push    
			pushi    80
			lsl      local0
			callk    FileIO,  8
			pushi    2
			pushi    1
			lsl      local0
			callk    FileIO,  4
			jmp      code_021d
code_020d:
			ldi      0
			sat      temp138
			pushi    2
			lea      @temp48
			push    
			lofsa    {resource.cfg}
			push    
			callk    StrCpy,  4
code_021d:
			lat      temp4
			bnt      code_0250
			pushi    #font
			pushi    1
			pushi    999
			pushi    198
			pushi    1
			lofsa    {Enter your login name\n(max 8 characters):}
			push    
			pushi    200
			pushi    4
			lea      @temp138
			push    
			pushi    12
			pushi    0
			pushi    20
			pushi    110
			pushi    0
			class    Print
			send     28
			pushi    3
			lea      @temp138
			push    
			pushi    8
			pushi    0
			callk    StrAt,  6
code_0250:
			lat      temp4
			not     
			bt       code_027a
			pushi    #font
			pushi    1
			pushi    999
			pushi    198
			pushi    1
			lofsa    {Enter configuration file name\n(or hit return to skip):}
			push    
			pushi    200
			pushi    4
			lea      @temp48
			push    
			pushi    30
			pushi    0
			pushi    20
			pushi    110
			pushi    0
			class    Print
			send     28
			bnt      code_02a4
code_027a:
			pushi    65535
			pushi    3
			pushi    0
			lea      @temp48
			push    
			pushi    1
			callk    FileIO,  6
			sal      local0
			eq?     
			bnt      code_02a4
			pushi    2
			lea      @temp48
			push    
			pushi    0
			callk    StrAt,  4
			bnt      code_02a4
			pushi    3
			lea      @temp48
			push    
			pushi    0
			pushi    0
			callk    StrAt,  6
			jmp      code_0250
code_02a4:
			pushi    65535
			lal      local0
			ne?     
			bnt      code_043e
code_02ac:
			pushi    4
			pushi    5
			lea      @temp8
			push    
			pushi    80
			lsl      local0
			callk    FileIO,  8
			bnt      code_0437
			ldi      0
			sat      temp0
code_02c2:
			pushi    2
			lea      @temp8
			push    
			lst      temp0
			callk    StrAt,  4
			sat      temp3
			bnt      code_02e3
			pushi    3
			push    
			pushi    9
			pushi    32
			calle    proc999_5,  6
			bnt      code_02e3
			+at      temp0
			jmp      code_02c2
code_02e3:
			ldi      0
			sat      temp1
code_02e7:
			pushi    2
			lea      @temp8
			push    
			lst      temp0
			callk    StrAt,  4
			sat      temp3
			bnt      code_031c
			pushi    5
			push    
			pushi    61
			pushi    58
			pushi    9
			pushi    32
			calle    proc999_5,  10
			not     
			bnt      code_031c
			pushi    3
			lea      @temp108
			push    
			lst      temp1
			lst      temp3
			callk    StrAt,  6
			+at      temp0
			+at      temp1
			jmp      code_02e7
code_031c:
			pushi    3
			lea      @temp108
			push    
			lst      temp1
			pushi    0
			callk    StrAt,  6
			pushi    0
			pushi    2
			lea      @temp108
			push    
			lofsa    {kbdDrv}
			push    
			callk    StrCmp,  4
			eq?     
			bnt      code_033e
			lea      @temp158
			jmp      code_03ab
code_033e:
			pushi    0
			pushi    2
			lea      @temp108
			push    
			lofsa    {joyDrv}
			push    
			callk    StrCmp,  4
			eq?     
			bnt      code_0353
			lea      @temp198
			jmp      code_03ab
code_0353:
			pushi    0
			pushi    2
			lea      @temp108
			push    
			lofsa    {videoDrv}
			push    
			callk    StrCmp,  4
			eq?     
			bnt      code_0368
			lea      @temp238
			jmp      code_03ab
code_0368:
			pushi    0
			pushi    2
			lea      @temp108
			push    
			lofsa    {soundDrv}
			push    
			callk    StrCmp,  4
			eq?     
			bnt      code_037f
			lea      @temp278
			jmp      code_03ab
code_037f:
			pushi    0
			pushi    2
			lea      @temp108
			push    
			lofsa    {mouseDrv}
			push    
			callk    StrCmp,  4
			eq?     
			bnt      code_0396
			lea      @temp318
			jmp      code_03ab
code_0396:
			pushi    0
			pushi    2
			lea      @temp108
			push    
			lofsa    {audioDrv}
			push    
			callk    StrCmp,  4
			eq?     
			bnt      code_03ab
			lea      @temp358
code_03ab:
			sat      temp5
			bnt      code_02ac
code_03b0:
			pushi    2
			lea      @temp8
			push    
			lst      temp0
			callk    StrAt,  4
			sat      temp3
			bnt      code_03d5
			pushi    5
			push    
			pushi    61
			pushi    58
			pushi    9
			pushi    32
			calle    proc999_5,  10
			bnt      code_03d5
			+at      temp0
			jmp      code_03b0
code_03d5:
			lat      temp0
			sat      temp1
			ldi      0
			sat      temp2
code_03dd:
			pushi    2
			lea      @temp8
			push    
			lst      temp1
			callk    StrAt,  4
			sat      temp3
			bnt      code_0415
			pushi    4
			push    
			pushi    58
			pushi    92
			pushi    47
			calle    proc999_5,  8
			bnt      code_0403
			lst      temp1
			ldi      1
			add     
			sat      temp0
code_0403:
			lst      temp3
			ldi      46
			eq?     
			bnt      code_0411
			lst      temp1
			lat      temp0
			sub     
			sat      temp2
code_0411:
			+at      temp1
			jmp      code_03dd
code_0415:
			lst      temp2
			ldi      0
			eq?     
			bnt      code_0423
			lst      temp1
			lat      temp0
			sub     
			sat      temp2
code_0423:
			pushi    3
			lst      temp5
			lea      @temp8
			push    
			lat      temp0
			add     
			push    
			lst      temp2
			callk    StrCpy,  6
			jmp      code_02ac
code_0437:
			pushi    2
			pushi    1
			lsl      local0
			callk    FileIO,  4
code_043e:
			pushi    4
			lea      @temp78
			push    
			pushi    952
			pushi    7
			lea      @global42
			push    
			callk    Format,  8
			lat      temp4
			bnt      code_04cc
			pushi    65535
			pushi    3
			pushi    0
			lea      @temp78
			push    
			pushi    1
			callk    FileIO,  6
			sal      local0
			eq?     
			bt       code_04b6
			pushi    4
			lea      @temp8
			push    
			pushi    952
			pushi    8
			lea      @temp78
			push    
			callk    Format,  8
			bnt      code_047f
			ldi      0
			bt       code_04b6
code_047f:
			pushi    #font
			pushi    1
			pushi    999
			pushi    198
			pushi    1
			lea      @temp8
			push    
			pushi    205
			pushi    4
			pushi    0
			lofsa    {Append to it}
			push    
			pushi    0
			pushi    12
			pushi    205
			pushi    4
			pushi    1
			lofsa    {Overwrite it}
			push    
			pushi    75
			pushi    12
			pushi    204
			pushi    1
			pushi    1
			pushi    110
			pushi    0
			class    Print
			send     46
			bnt      code_04cc
code_04b6:
			pushi    2
			pushi    1
			lsl      local0
			callk    FileIO,  4
			pushi    3
			pushi    0
			lea      @temp78
			push    
			pushi    2
			callk    FileIO,  6
			sal      local0
			jmp      code_04d9
code_04cc:
			pushi    3
			pushi    0
			lea      @temp78
			push    
			pushi    0
			callk    FileIO,  6
			sal      local0
code_04d9:
			pushi    65535
			lal      local0
			eq?     
			bnt      code_04fc
			pushi    #font
			pushi    1
			pushi    999
			pushi    199
			pushi    2
			lofsa    {Error: Couldn't open %s}
			push    
			lea      @temp78
			push    
			pushi    110
			pushi    0
			class    Print
			send     18
			jmp      code_0962
code_04fc:
			pushi    3
			pushi    1
			lofsa    {GAME}
			push    
			pushi    #name
			pushi    0
			lag      gGame
			send     4
			push    
			call     localproc_0010,  6
			pushi    3
			pushi    1
			lofsa    {VERSION}
			push    
			lsg      global27
			call     localproc_0010,  6
			pushi    2
			pushi    7
			lofsa    {QA-DATE}
			push    
			call     localproc_0010,  4
			pushi    3
			pushi    1
			lofsa    {ANALYST}
			push    
			lea      @temp138
			push    
			call     localproc_0010,  6
			pushi    3
			pushi    1
			lofsa    {SEVERITY}
			push    
			pushi    #font
			pushi    1
			pushi    999
			pushi    198
			pushi    1
			lofsa    {Severity of bug...}
			push    
			pushi    205
			pushi    4
			lofsa    {F}
			push    
			lofsa    {FATAL}
			push    
			pushi    0
			pushi    12
			pushi    205
			pushi    4
			lofsa    {N}
			push    
			lofsa    {NON-FATAL}
			push    
			pushi    40
			pushi    12
			pushi    205
			pushi    4
			lofsa    {S}
			push    
			lofsa    {SUGGESTION}
			push    
			pushi    110
			pushi    12
			pushi    204
			pushi    1
			pushi    1
			pushi    110
			pushi    0
			class    Print
			send     58
			push    
			call     localproc_0010,  6
			ldi      1
			sat      temp0
			ldi      1
			sat      temp6
code_0596:
			lst      temp0
			ldi      10
			le?     
			bnt      code_05e7
			pushi    4
			lea      @temp108
			push    
			pushi    952
			pushi    9
			lst      temp0
			callk    Format,  8
			pushi    5
			lea      @temp8
			push    
			pushi    952
			pushi    10
			lst      temp0
			pushi    10
			callk    Format,  10
			lat      temp6
			bnt      code_05d7
			pushi    3
			pushi    5
			lea      @temp108
			push    
			lea      @temp8
			push    
			call     localproc_0010,  6
			sat      temp6
			jmp      code_05e3
code_05d7:
			pushi    3
			pushi    1
			lea      @temp108
			push    
			pushi    0
			call     localproc_0010,  6
code_05e3:
			+at      temp0
			jmp      code_0596
code_05e7:
			pushi    3
			pushi    1
			lofsa    {DEPARTMENT}
			push    
			pushi    #font
			pushi    1
			pushi    999
			pushi    198
			pushi    1
			lofsa    {Who can fix bug...}
			push    
			pushi    205
			pushi    4
			lofsa    {P}
			push    
			lofsa    {PROG}
			push    
			pushi    0
			pushi    12
			pushi    205
			pushi    4
			lofsa    {A}
			push    
			lofsa    {ART}
			push    
			pushi    40
			pushi    12
			pushi    205
			pushi    4
			lofsa    {D}
			push    
			lofsa    {DESIGN}
			push    
			pushi    80
			pushi    12
			pushi    204
			pushi    1
			pushi    1
			pushi    110
			pushi    0
			class    Print
			send     58
			push    
			call     localproc_0010,  6
			pushi    3
			pushi    2
			lofsa    {ROOM}
			push    
			lsg      gNumber
			call     localproc_0010,  6
			pushi    #script
			pushi    0
			lag      global2
			send     4
			sat      temp0
			pushi    3
			pushi    1
			lofsa    {ROOM-SCRIPT}
			push    
			lat      temp0
			bnt      code_0666
			pushi    #name
			pushi    0
			send     4
code_0666:
			push    
			call     localproc_0010,  6
			pushi    3
			pushi    2
			lofsa    {ROOM-STATE}
			push    
			lat      temp0
			bnt      code_067b
			pushi    #state
			pushi    0
			send     4
code_067b:
			push    
			call     localproc_0010,  6
			pushi    3
			pushi    2
			lofsa    {EGO-X}
			push    
			pushi    #x
			pushi    0
			lag      gEgo
			send     4
			push    
			call     localproc_0010,  6
			pushi    3
			pushi    2
			lofsa    {EGO-Y}
			push    
			pushi    #y
			pushi    0
			lag      gEgo
			send     4
			push    
			call     localproc_0010,  6
			pushi    3
			pushi    2
			lofsa    {EGO-Z}
			push    
			pushi    #z
			pushi    0
			lag      gEgo
			send     4
			push    
			call     localproc_0010,  6
			pushi    #script
			pushi    0
			lag      gEgo
			send     4
			sat      temp0
			pushi    3
			pushi    1
			lofsa    {EGO-SCRIPT}
			push    
			lat      temp0
			bnt      code_06d1
			pushi    #name
			pushi    0
			send     4
code_06d1:
			push    
			call     localproc_0010,  6
			pushi    3
			pushi    2
			lofsa    {EGO-STATE}
			push    
			lat      temp0
			bnt      code_06e6
			pushi    #state
			pushi    0
			send     4
code_06e6:
			push    
			call     localproc_0010,  6
			pushi    3
			pushi    2
			lofsa    {EGO-VIEW}
			push    
			pushi    #view
			pushi    0
			lag      gEgo
			send     4
			push    
			call     localproc_0010,  6
			pushi    3
			pushi    2
			lofsa    {EGO-LOOP}
			push    
			pushi    #loop
			pushi    0
			lag      gEgo
			send     4
			push    
			call     localproc_0010,  6
			pushi    3
			pushi    2
			lofsa    {EGO-CEL}
			push    
			pushi    #cel
			pushi    0
			lag      gEgo
			send     4
			push    
			call     localproc_0010,  6
			pushi    3
			pushi    2
			lofsa    {EGO-PRIORITY}
			push    
			pushi    #priority
			pushi    0
			lag      gEgo
			send     4
			push    
			call     localproc_0010,  6
			pushi    3
			pushi    2
			lofsa    {EGO-HEADING}
			push    
			pushi    #heading
			pushi    0
			lag      gEgo
			send     4
			push    
			call     localproc_0010,  6
			pushi    3
			pushi    1
			lofsa    {CYCLER}
			push    
			pushi    #cycler
			pushi    0
			lag      gEgo
			send     4
			bnt      code_0767
			pushi    #name
			pushi    0
			pushi    #cycler
			pushi    0
			lag      gEgo
			send     4
			send     4
code_0767:
			push    
			call     localproc_0010,  6
			pushi    #mover
			pushi    0
			lag      gEgo
			send     4
			sat      temp0
			pushi    3
			pushi    1
			lofsa    {EGO-MOVER}
			push    
			lat      temp0
			bnt      code_0785
			pushi    #name
			pushi    0
			send     4
code_0785:
			push    
			call     localproc_0010,  6
			pushi    3
			pushi    2
			lofsa    {MOVER-X}
			push    
			lat      temp0
			not     
			bnt      code_079a
			ldi      0
			jmp      code_07b6
code_079a:
			pushi    #isMemberOf
			pushi    1
			class    PolyPath
			push    
			lat      temp0
			send     6
			bnt      code_07b0
			pushi    #finalX
			pushi    0
			lat      temp0
			send     4
			jmp      code_07b6
code_07b0:
			pushi    #x
			pushi    0
			lat      temp0
			send     4
code_07b6:
			push    
			call     localproc_0010,  6
			pushi    3
			pushi    2
			lofsa    {MOVER-Y}
			push    
			lat      temp0
			not     
			bnt      code_07cb
			ldi      0
			jmp      code_07e7
code_07cb:
			pushi    #isMemberOf
			pushi    1
			class    PolyPath
			push    
			lat      temp0
			send     6
			bnt      code_07e1
			pushi    #finalY
			pushi    0
			lat      temp0
			send     4
			jmp      code_07e7
code_07e1:
			pushi    #y
			pushi    0
			lat      temp0
			send     4
code_07e7:
			push    
			call     localproc_0010,  6
			pushi    3
			pushi    2
			lofsa    {EGO-MOVESPD}
			push    
			pushi    #moveSpeed
			pushi    0
			lag      gEgo
			send     4
			push    
			call     localproc_0010,  6
			pushi    3
			pushi    4
			lofsa    {SIGNAL-BITS}
			push    
			pushi    #signal
			pushi    0
			lag      gEgo
			send     4
			push    
			call     localproc_0010,  6
			pushi    3
			pushi    4
			lofsa    {ILLEGAL-BITS}
			push    
			pushi    #illegalBits
			pushi    0
			lag      gEgo
			send     4
			push    
			call     localproc_0010,  6
			pushi    3
			pushi    2
			lofsa    {HOWFAST}
			push    
			lsg      global87
			call     localproc_0010,  6
			pushi    3
			pushi    1
			lofsa    {ICONBAR}
			push    
			lag      gIconBar
			bnt      code_0844
			pushi    #name
			pushi    0
			send     4
code_0844:
			push    
			call     localproc_0010,  6
			pushi    3
			pushi    1
			lofsa    {CUR-ICON}
			push    
			lag      gIconBar
			bnt      code_0869
			pushi    #curIcon
			pushi    0
			send     4
			bnt      code_0869
			pushi    #name
			pushi    0
			pushi    #curIcon
			pushi    0
			lag      gIconBar
			send     4
			send     4
code_0869:
			push    
			call     localproc_0010,  6
			pushi    3
			pushi    2
			lofsa    {DETAIL-LEVEL}
			push    
			pushi    #detailLevel
			pushi    0
			lag      gGame
			send     4
			push    
			call     localproc_0010,  6
			pushi    3
			pushi    2
			lofsa    {CD-AUDIO}
			push    
			lsg      global83
			call     localproc_0010,  6
			pushi    3
			pushi    1
			lofsa    {VIDEO-DRV}
			push    
			lea      @temp238
			push    
			call     localproc_0010,  6
			pushi    3
			pushi    1
			lofsa    {SOUND-DRV}
			push    
			lea      @temp278
			push    
			call     localproc_0010,  6
			pushi    3
			pushi    1
			lofsa    {AUDIO-DRV}
			push    
			lea      @temp358
			push    
			call     localproc_0010,  6
			pushi    3
			pushi    1
			lofsa    {KEYBOARD-DRV}
			push    
			lea      @temp158
			push    
			call     localproc_0010,  6
			pushi    3
			pushi    1
			lofsa    {JOY-DRV}
			push    
			lea      @temp198
			push    
			call     localproc_0010,  6
			pushi    3
			pushi    1
			lofsa    {MOUSE}
			push    
			lea      @temp318
			push    
			call     localproc_0010,  6
			pushi    3
			dup     
			lofsa    {LARGEST-HEAP}
			push    
			pushi    1
			pushi    0
			callk    MemoryInfo,  2
			push    
			call     localproc_0010,  6
			pushi    3
			dup     
			lofsa    {FREE-HEAP}
			push    
			pushi    1
			pushi    1
			callk    MemoryInfo,  2
			push    
			call     localproc_0010,  6
			pushi    3
			dup     
			lofsa    {TOTAL-HUNK}
			push    
			pushi    1
			pushi    4
			callk    MemoryInfo,  2
			push    
			ldi      6
			shr     
			push    
			call     localproc_0010,  6
			pushi    3
			dup     
			lofsa    {LARGEST-HUNK}
			push    
			pushi    1
			pushi    2
			callk    MemoryInfo,  2
			push    
			call     localproc_0010,  6
			pushi    3
			dup     
			lofsa    {FREE-HUNK}
			push    
			pushi    1
			pushi    3
			callk    MemoryInfo,  2
			push    
			ldi      6
			shr     
			push    
			call     localproc_0010,  6
			pushi    3
			pushi    6
			lsl      local0
			lofsa    {**********************************\0D\n}
			push    
			callk    FileIO,  6
			pushi    2
			pushi    1
			lsl      local0
			callk    FileIO,  4
code_0962:
			pushi    4
			lea      @temp78
			push    
			pushi    952
			pushi    6
			lea      @global42
			push    
			callk    Format,  8
			pushi    65535
			pushi    3
			pushi    0
			lea      @temp78
			push    
			pushi    2
			callk    FileIO,  6
			sal      local0
			eq?     
			bnt      code_09b4
			pushi    65535
			pushi    3
			pushi    0
			lea      @temp78
			push    
			pushi    0
			callk    FileIO,  6
			sal      local0
			eq?     
			bnt      code_09b4
			pushi    #font
			pushi    1
			pushi    999
			pushi    199
			pushi    2
			lofsa    {Error: Couldn't open memory file %s!}
			push    
			lea      @temp78
			push    
			pushi    110
			pushi    0
			class    Print
			send     18
			jmp      code_09ef
code_09b4:
			pushi    3
			pushi    6
			lsl      local0
			lea      @temp138
			push    
			callk    FileIO,  6
			pushi    3
			pushi    6
			lsl      local0
			lofsa    {\n}
			push    
			callk    FileIO,  6
			pushi    3
			pushi    6
			lsl      local0
			lea      @temp48
			push    
			callk    FileIO,  6
			pushi    3
			pushi    6
			lsl      local0
			lofsa    {\n}
			push    
			callk    FileIO,  6
			pushi    2
			pushi    1
			lsl      local0
			callk    FileIO,  4
code_09ef:
			lat      temp7
			sag      gFont_2
			pushi    1
			pushi    952
			callk    DisposeScript,  2
			ret     
		)
	)
)
