;;; Sierra Script 1.0 - (do not remove this comment)
(script# 803)
(include sci.sh)
(use Main)
(use EcoFeature)
(use Cycle)
(use Game)
(use Obj)

(public
	speedTest 0
)

(local
	local0
	local1
	local2
	local3
)
(instance fred of EcoActor
	(properties)
)

(instance speedTest of Rm
	(properties
		picture 901
		style $0064
	)
	
	(method (init)
		(= local1 (FileIO fiOPEN {version} 1))
		(FileIO fiREAD_STRING global27 6 local1)
		(FileIO fiCLOSE local1)
		(super init:)
		(gSounds eachElementDo: #stop)
		(while (u> (GetTime) -1024)
		)
		(fred
			view: 901
			setLoop: 0
			illegalBits: 0
			posn: 20 99
			setStep: 1 1
			setMotion: MoveTo 300 100
			setCycle: Fwd
			init:
		)
		(= global111 0)
		(= local3 (if (> global102 16) 110 else 50))
		(= local2 (if (> global102 16) 65 else 30))
	)
	
	(method (doit)
		(super doit:)
		(if (== (++ global111) 1)
			(= local0 (+ 60 (GetTime)))
		)
		(if
		(and (u< local0 (GetTime)) (not (self script?)))
			(cond 
				((< global111 local2) (= global87 0) (gGame detailLevel: 1))
				((< global111 local3) (= global87 1) (gGame detailLevel: 2))
				(else (= global87 2) (gGame detailLevel: 3))
			)
			(self setScript: speedScript)
		)
	)
	
	(method (dispose)
		(super dispose:)
	)
)

(instance speedScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= cycles 1))
			(1
				(gIconBar enable:)
				(global2 newRoom: global104)
			)
		)
	)
)
